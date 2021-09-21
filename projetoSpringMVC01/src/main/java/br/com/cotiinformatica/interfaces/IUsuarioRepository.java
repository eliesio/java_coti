package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.entities.Usuario;

public interface IUsuarioRepository extends ICrudRepository<Usuario, Integer> {

	Usuario getByEmail(String email) throws Exception;

	Usuario getByEmailSenha(String email, String senha) throws Exception;
}
