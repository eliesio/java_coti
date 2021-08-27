package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.TarefasCadastroDTO;

//Qualifica a classe como um CONTROLLER no framework Spring
@Controller // Annotation
public class TarefasController {

	@RequestMapping("/tarefas-cadastro") // ROTA (URL)
	public ModelAndView cadastro() {
		// WEB-INF/views/tarefas/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		// enviando para a página um objeto dto novo! (em branco)
		modelAndView.addObject("tarefas-dto", new TarefasCadastroDTO());

		return modelAndView;
	}

	// método para receber o POST do formulário de cadastro de tarefa
	@RequestMapping(value = "/cadastrar-tarefa", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(TarefasCadastroDTO dto) {

		try {
			// TODO
		} catch (Exception e) {
			// TODO: handle exception
		}

		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");
		modelAndView.addObject("tarefas-dto", dto);
		
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

	@RequestMapping("/tarefas-edicao") // ROTA (URL)
	public ModelAndView edicao() {
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");
		return modelAndView;
	}

}


