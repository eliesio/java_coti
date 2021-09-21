package br.com.cotiinformatica.controller;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.TarefasCadastroDTO;
import br.com.cotiinformatica.dtos.TarefasEdicaoDTO;
import br.com.cotiinformatica.dtos.TarefasRelatorioDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.reports.TarefasReport;

//Qualifica a classe como um CONTROLLER no framework Spring
@Controller // Annotation
public class TarefasController {
	
	//inje��o de dependencia
	@Autowired //inicializar automaticamente (inje��o de dependencia)
	private ITarefaRepository tarefaRepository;

	@RequestMapping("/tarefas-cadastro") // ROTA (URL)
	public ModelAndView cadastro() {
		// WEB-INF/views/tarefas/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		// enviando para a p�gina um objeto dto novo! (em branco)
		modelAndView.addObject("tarefas-dto", new TarefasCadastroDTO());
		
		//enviando para a p�gina o conteudo do ENUM (PrioridadeTarefa)
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		
		return modelAndView;
	}

	// m�todo para receber o POST do formul�rio de cadastro de tarefa
	@RequestMapping(value = "/cadastrar-tarefa", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(TarefasCadastroDTO dto, HttpServletRequest request) {

		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");
		
		try {

			//capturar todas as informa��es trazidas pelo DTO
			Tarefa tarefa = new Tarefa();
			tarefa.setUsuario(usuario);
			
			tarefa.setNome(dto.getNome());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));
			
			//gravar no banco de dados
			tarefaRepository.create(tarefa);
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa cadastrada com sucesso.");
			dto = new TarefasCadastroDTO(); //limpar todas as informa��es no DTO
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("tarefas-dto", dto);
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		
		return modelAndView;
	}

	@RequestMapping("/tarefas-consulta") // ROTA (URL)
	public ModelAndView consulta(HttpServletRequest request) {
		
		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		// WEB-INF/views/tarefas/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");
		
		try {
			//consultar todas as tarefas no banco de dados
			//para ent�o exibi-las na p�gina de consulta
			modelAndView.addObject("tarefas", tarefaRepository.getByUsuario(usuario.getIdUsuario()));
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
		modelAndView.addObject("relatorio-dto", new TarefasRelatorioDTO());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/gerar-relatorio", method = RequestMethod.POST) // ROTA (URL)
	public ModelAndView gerarRelatorio(TarefasRelatorioDTO dto, HttpServletRequest request, HttpServletResponse response) {
		
		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");
		modelAndView.addObject("relatorio-dto", new TarefasRelatorioDTO());
		
		try {
			
			//resgatar as datas obtidas no formulario
			Date dataMin = DateHelper.toDate(dto.getDataMin());
			Date dataMax = DateHelper.toDate(dto.getDataMax());
			
			//consultar no banco de dados as tarefas por periodo de data
			List<Tarefa> tarefas = tarefaRepository.getByDatas(dataMin, dataMax, usuario.getIdUsuario());
								
			//gerar o relatorio PDF..
			ByteArrayInputStream stream = TarefasReport.getPdf(dataMin, dataMax, tarefas, usuario);
			
			//DOWNLOAD de um relatorio..	
			response.setContentType("application/pdf");
			response.addHeader("Content-disposition", "attachment; filename=tarefas.pdf");
			
			byte[] dados = stream.readAllBytes();
			
			OutputStream out = response.getOutputStream();
			out.write(dados, 0, dados.length);
			out.flush();
			out.close();			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}

	@RequestMapping("/tarefas-edicao") // ROTA (URL)
	public ModelAndView edicao(Integer id, HttpServletRequest request) {
		
		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
				
		// WEB-INF/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");
		
		try {
			
			//consultar a tarefa no banco de dados atraves do ID..
			Tarefa tarefa = tarefaRepository.getById(id);
			
			//verificar se a tarefa pertence ao usuario autenticado
			if(tarefa.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
				throw new Exception("Erro. A tarefa selecionada n�o pertence ao usuario autenticado.");
			}
			
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
	public ModelAndView atualizarTarefa(TarefasEdicaoDTO dto, HttpServletRequest request) {
	
		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");
		
		try {
			
			Tarefa tarefa = new Tarefa();
			tarefa.setUsuario(usuario);
			
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
	
	//m�todo para executar a exclus�o da tarefa
	@RequestMapping(value = "/tarefas-exclusao")
	public ModelAndView excluirTarefa(Integer id, HttpServletRequest request) {
		
		//Capturar o usuario autenticado no sistema (ler da sess�o)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");
		
		try {
			
			//buscar a tarefa no banco de dados atraves do ID..
			Tarefa tarefa = tarefaRepository.getById(id);
			
			//verificar se a tarefa pertence ao usuario autenticado
			if(tarefa.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
				throw new Exception("Erro. A tarefa selecionada n�o pertence ao usuario autenticado.");
			}
			
			//excluir a tarefa
			tarefaRepository.delete(tarefa);
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa exclu�da com sucesso.");
			
			//recarregando a consulta..
			modelAndView.addObject("tarefas", tarefaRepository.getByUsuario(usuario.getIdUsuario()));
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}

}








