package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.AccountLoginDTO;
import br.com.cotiinformatica.dtos.AccountRegisterDTO;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Controller
public class AccountController {

	@Autowired // injeção de dependência (inicialização)
	private IUsuarioRepository usuarioRepository;

	@RequestMapping("/") // raiz do projeto
	public ModelAndView login() {
		// WEB-INF/views/account/login.jsp
		ModelAndView modelAndView = new ModelAndView("account/login");

		// enviando para a página uma instancia do DTO
		modelAndView.addObject("login-dto", new AccountLoginDTO());

		return modelAndView;
	}

	@RequestMapping(value = "autenticar-usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(AccountLoginDTO dto, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("account/login");

		try {

			// buscar no banco de dados o usuario atraves do email e da senha
			Usuario usuario = usuarioRepository.getByEmailSenha(dto.getEmail(), dto.getSenha());

			// verificar se o usuario foi encontrado..
			if (usuario != null) {

				// gravar os dados do usuario em uma sessão..
				request.getSession().setAttribute("user_auth", usuario);
				modelAndView.setViewName("redirect:/home"); // redirecionar
			} else {
				modelAndView.addObject("mensagem_erro", "Acesso Negado. Usuário inválido.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		// enviando para a página uma instancia do DTO
		modelAndView.addObject("login-dto", new AccountLoginDTO());

		return modelAndView;

	}

	@RequestMapping("/register") // cadastro de usuário
	public ModelAndView register() {
		// WEB-INF/views/account/register.jsp
		ModelAndView modelAndView = new ModelAndView("account/register");

		// enviando para a página uma instancia do DTO
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
						"O email " + dto.getEmail() + " informado já encontra-se cadastrado, tente outro.");
			} else {

				Usuario usuario = new Usuario();

				usuario.setNome(dto.getNome());
				usuario.setEmail(dto.getEmail());
				usuario.setSenha(dto.getSenha());

				usuarioRepository.create(usuario); // gravando no banco!

				modelAndView.addObject("mensagem_sucesso", "Parabéns, sua conta de usuario foi criada com sucesso.");
				dto = new AccountRegisterDTO();
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		// enviando para a página uma instancia do DTO
		modelAndView.addObject("register-dto", dto);

		return modelAndView;
	}

	@RequestMapping("/password-recover") // recuperar a senha do usuario
	public ModelAndView passwordrecover() {
		// WEB-INF/views/account/passwordrecover.jsp
		ModelAndView modelAndView = new ModelAndView("account/passwordrecover");
		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		// apagar os dados gravados em sessão
		request.getSession().removeAttribute("user_auth");

		// redirecionar de volta para a página de login (página inicial)
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

}
