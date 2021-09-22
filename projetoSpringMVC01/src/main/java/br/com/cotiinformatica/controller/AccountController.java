package br.com.cotiinformatica.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.AccountLoginDTO;
import br.com.cotiinformatica.dtos.AccountPasswordRecoverDTO;
import br.com.cotiinformatica.dtos.AccountRegisterDTO;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;
import br.com.cotiinformatica.mail.EmailService;

@Controller
public class AccountController {

	@Autowired // inje��o de depend�ncia (inicializa��o)
	private IUsuarioRepository usuarioRepository;

	@RequestMapping("/") // raiz do projeto
	public ModelAndView login() {
		// WEB-INF/views/account/login.jsp
		ModelAndView modelAndView = new ModelAndView("account/login");

		// enviando para a p�gina uma instancia do DTO
		modelAndView.addObject("login-dto", new AccountLoginDTO());

		return modelAndView;
	}
	
	@RequestMapping(value = "autenticar-usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(AccountLoginDTO dto, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("account/login");
		
		try {
			
			//buscar no banco de dados o usuario atraves do email e da senha
			Usuario usuario = usuarioRepository.getByEmailSenha(dto.getEmail(), dto.getSenha());
			
			//verificar se o usuario foi encontrado..
			if(usuario != null) {
				
				//gravar os dados do usuario em uma sess�o..
				request.getSession().setAttribute("user_auth", usuario);
				modelAndView.setViewName("redirect:/home"); //redirecionar
			}
			else {
				modelAndView.addObject("mensagem_erro", "Acesso Negado. Usu�rio inv�lido.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		// enviando para a p�gina uma instancia do DTO
		modelAndView.addObject("login-dto", new AccountLoginDTO());

		return modelAndView;
		
	}

	@RequestMapping("/register") // cadastro de usu�rio
	public ModelAndView register() {
		// WEB-INF/views/account/register.jsp
		ModelAndView modelAndView = new ModelAndView("account/register");

		// enviando para a p�gina uma instancia do DTO
		modelAndView.addObject("register-dto", new AccountRegisterDTO());

		return modelAndView;
	}

	@RequestMapping(value = "cadastrar-usuario", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(AccountRegisterDTO dto) {

		ModelAndView modelAndView = new ModelAndView("account/register");

		try {

			// verificando se ja existe no banco um usuario cadastrado com o email
			if (usuarioRepository.getByEmail(dto.getEmail()) != null) {
				modelAndView.addObject("mensagem_erro",
						"O email " + dto.getEmail() + " informado j� encontra-se cadastrado, tente outro.");
			} else {

				Usuario usuario = new Usuario();

				usuario.setNome(dto.getNome());
				usuario.setEmail(dto.getEmail());
				usuario.setSenha(dto.getSenha());

				usuarioRepository.create(usuario); // gravando no banco!

				modelAndView.addObject("mensagem_sucesso", "Parab�ns, sua conta de usuario foi criada com sucesso.");
				dto = new AccountRegisterDTO();
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		// enviando para a p�gina uma instancia do DTO
		modelAndView.addObject("register-dto", dto);

		return modelAndView;
	}

	@RequestMapping("/password-recover") // recuperar a senha do usuario
	public ModelAndView passwordrecover() {
		// WEB-INF/views/account/passwordrecover.jsp
		ModelAndView modelAndView = new ModelAndView("account/passwordrecover");
		
		modelAndView.addObject("passwordrecover-dto", new AccountPasswordRecoverDTO());		
		return modelAndView;
	}
	
	@RequestMapping(value = "recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(AccountPasswordRecoverDTO dto) {
		
		// WEB-INF/views/account/passwordrecover.jsp
		ModelAndView modelAndView = new ModelAndView("account/passwordrecover");
		
		try {
			
			//buscar o usuario no banco de dados atraves do email..
			Usuario usuario = usuarioRepository.getByEmail(dto.getEmail());
			
			if(usuario == null) //se o usuario n�o foi encontrado
				throw new Exception("O email informado '"+ dto.getEmail() +"' n�o foi encontrado. Tente novamente.");
			
			//gerar uma nova senha para o usuario
			usuario.setSenha(String.valueOf(new Random().nextInt(999999999)));
			usuarioRepository.update(usuario);
			
			//enviando um email para o usuario com a nova senha
			EmailService.enviarMensagem(usuario.getEmail(), "Nova senha gerada com sucesso - COTI Inform�tica", 
					"Olá, " + usuario.getNome() +
					"\n\nSua nova senha foi gerada com sucesso: " + usuario.getSenha() +
					"\nUtilize esta senha para acessar o sistema" + 
					"\n\nAtt\nEquipe COTI Informática.");
			
			modelAndView.addObject("mensagem_sucesso", "Nova senha gerada com sucesso. Acesse sua conta de email.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("passwordrecover-dto", new AccountPasswordRecoverDTO());		
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar os dados gravados em sess�o
		request.getSession().removeAttribute("user_auth");
		
		//redirecionar de volta para a p�gina de login (p�gina inicial)
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

}
