package br.com.cotiinformatica.interfaces;

import java.util.List;

/*
 * <T>  tipo generico que irá representar uma entidade
 * <ID> tipo generico que irá representar a chave primária da entidade
 */
public interface ICrudRepository<T, ID> {

	// métodos abstratos
	void create(T obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	List<T> getAll() throws Exception;

	T getById(ID id) throws Exception;
}
