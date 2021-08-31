package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.TarefasCadastroDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

//Qualifica a classe como um CONTROLLER no framework Spring
@Controller // Annotation
public class TarefasController {

	// injeção de dependencia
	@Autowired // inicializar automaticamente (injeção de dependencia)
	private ITarefaRepository tarefaRepository;

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

		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		try {

			// capturar todas as informações trazidas pelo DTO
			Tarefa tarefa = new Tarefa();

			tarefa.setNome(dto.getNome());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));

			// gravar no banco de dados
			tarefaRepository.create(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa cadastrada com sucesso.");
			dto = new TarefasCadastroDTO(); // limpar todas as informações no DTO

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

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
