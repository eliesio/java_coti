package br.com.cotiinformatica.interfaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.dtos.PrioridadeTarefaDTO;
import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository extends ICrudRepository<Tarefa, Integer> {

	// método abstrato que será utilizado pela pagina de consulta de tarefas
	List<Tarefa> getByUsuario(Integer idUsuario) throws Exception;

	// método abstrato que será utilizado pela pagina de relatorio de tarefas
	List<Tarefa> getByDatas(Date dataMin, Date dataMax, Integer idUsuario) throws Exception;

	// método abstrato que será utilizado para retornar os dados do gráfico
	List<PrioridadeTarefaDTO> getGroupByPrioridade(Integer idUsuario) throws Exception;

}
