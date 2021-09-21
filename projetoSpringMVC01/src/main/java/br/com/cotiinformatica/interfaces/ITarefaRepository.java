package br.com.cotiinformatica.interfaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.dtos.PrioridadeTarefaDTO;
import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository extends ICrudRepository<Tarefa, Integer> {

	// m�todo abstrato que ser� utilizado pela pagina de consulta de tarefas
	List<Tarefa> getByUsuario(Integer idUsuario) throws Exception;

	// m�todo abstrato que ser� utilizado pela pagina de relatorio de tarefas
	List<Tarefa> getByDatas(Date dataMin, Date dataMax, Integer idUsuario) throws Exception;

	// m�todo abstrato que ser� utilizado para retornar os dados do gr�fico
	List<PrioridadeTarefaDTO> getGroupByPrioridade(Integer idUsuario) throws Exception;

}
