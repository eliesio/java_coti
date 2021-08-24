package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Qualifica a classe como um CONTROLLER no framework Spring
@Controller // Annotation
public class TarefasController {

	@RequestMapping("/tarefas-cadastro") // ROTA (URL)
	public ModelAndView cadastro() {
		// WEB-INF/views/tarefas/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");
		return modelAndView;
	}

	@RequestMapping("/tarefas-consulta") // ROTA (URL)
	public ModelAndView consulta() {
		// WEB-INF/views/tarefas/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");
		return modelAndView;
	}

	@RequestMapping("/tarefas-relatorio") // ROTA (URL)
	public ModelAndView relatorio() {
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");
		return modelAndView;
	}

}
