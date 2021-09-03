package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.TarefasCadastroDTO;
import br.com.cotiinformatica.dtos.TarefasEdicaoDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

//Qualifica a classe como um CONTROLLER no framework Spring
@Controller // Annotation
public class TarefasController {
	
	//injeção de dependencia
	@Autowired //inicializar automaticamente (injeção de dependencia)
	private ITarefaRepository tarefaRepository;

	@RequestMapping("/tarefas-cadastro") // ROTA (URL)
	public ModelAndView cadastro() {
		// WEB-INF/views/tarefas/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		// enviando para a página um objeto dto novo! (em branco)
		modelAndView.addObject("tarefas-dto", new TarefasCadastroDTO());
		
		//enviando para a página o conteudo do ENUM (PrioridadeTarefa)
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		
		return modelAndView;
	}

	// método para receber o POST do formulário de cadastro de tarefa
	@RequestMapping(value = "/cadastrar-tarefa", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(TarefasCadastroDTO dto) {

		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");
		
		try {

			//capturar todas as informações trazidas pelo DTO
			Tarefa tarefa = new Tarefa();
			
			tarefa.setNome(dto.getNome());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));
			
			//gravar no banco de dados
			tarefaRepository.create(tarefa);
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa cadastrada com sucesso.");
			dto = new TarefasCadastroDTO(); //limpar todas as informações no DTO
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("tarefas-dto", dto);
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		
		return modelAndView;
	}

	@RequestMapping("/tarefas-consulta") // ROTA (URL)
	public ModelAndView consulta() {
		// WEB-INF/views/tarefas/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");
		
		try {
			//consultar todas as tarefas no banco de dados
			//para então exibi-las na página de consulta
			modelAndView.addObject("tarefas", tarefaRepository.getAll());
		}	
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}

	@RequestMapping("/tarefas-relatorio") // ROTA (URL)
	public ModelAndView relatorio() {
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");
		return modelAndView;
	}

	@RequestMapping("/tarefas-edicao") // ROTA (URL)
	public ModelAndView edicao(Integer id) {
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");
		
		try {
			
			//consultar a tarefa no banco de dados atraves do ID..
			Tarefa tarefa = tarefaRepository.getById(id);
			
			//transferir os dados da tarefa para o DTO..
			TarefasEdicaoDTO dto = new TarefasEdicaoDTO();
			dto.setIdTarefa(tarefa.getIdTarefa());
			dto.setNome(tarefa.getNome());
			dto.setData(DateHelper.toString(tarefa.getData()));
			dto.setHora(tarefa.getHora());
			dto.setDescricao(tarefa.getDescricao());
			dto.setPrioridade(tarefa.getPrioridade().toString());
			
			modelAndView.addObject("tarefas-dto", dto);
			modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/atualizar-tarefa", method = RequestMethod.POST)
	public ModelAndView atualizarTarefa(TarefasEdicaoDTO dto) {
	
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");
		
		try {
			
			Tarefa tarefa = new Tarefa();
			
			tarefa.setIdTarefa(dto.getIdTarefa());
			tarefa.setNome(dto.getNome());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));
			
			tarefaRepository.update(tarefa); //atualizando no banco de dados
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa atualizada com sucesso!");
			
			modelAndView.addObject("tarefas-dto", dto);
			modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
	//método para executar a exclusão da tarefa
	@RequestMapping(value = "/tarefas-exclusao")
	public ModelAndView excluirTarefa(Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");
		
		try {
			
			//buscar a tarefa no banco de dados atraves do ID..
			Tarefa tarefa = tarefaRepository.getById(id);
			//excluir a tarefa
			tarefaRepository.delete(tarefa);
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa excluída com sucesso.");
			
			//recarregando a consulta..
			modelAndView.addObject("tarefas", tarefaRepository.getAll());
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}

}










