package br.com.cotiinformatica.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

@Controller
public class HomeController {

	@Autowired
	private ITarefaRepository tarefaRepository;

	@RequestMapping(value = "/home") // raiz do projeto
	public ModelAndView test(HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("home");

		try {

			// obter o usuario autenticado na aplicação
			Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");

			// consultando os dados para geração do grafico
			modelAndView.addObject("dados_grafico", tarefaRepository.getGroupByPrioridade(usuario.getIdUsuario()));
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView; // página
	}
}
