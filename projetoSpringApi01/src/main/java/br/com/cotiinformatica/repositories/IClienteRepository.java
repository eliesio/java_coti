package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

	/*
	 * JPQL - JAVA PERSISTENCE QUERY LANGUAGE
	 * Método para consultar 1 cliente pelo cpf
	 */
	@Query("from Cliente c where c.cpf = :param")
	Cliente findByCpf(@Param("param") String cpf);
	
	/*
	 * JPQL - JAVA PERSISTENCE QUERY LANGUAGE
	 * Método para consultar 1 cliente pelo email
	 */
	@Query("from Cliente c where c.email = :param")
	Cliente findByEmail(@Param("param") String email);
}
