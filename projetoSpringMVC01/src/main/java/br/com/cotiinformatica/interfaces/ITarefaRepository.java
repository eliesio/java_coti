package br.com.cotiinformatica.interfaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository extends ICrudRepository<Tarefa, Integer> {

	// método abstrato
	List<Tarefa> getByDatas(Date dataMin, Date dataMax) throws Exception;

}