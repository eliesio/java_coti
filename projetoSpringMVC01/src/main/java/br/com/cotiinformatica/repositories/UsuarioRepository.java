package br.com.cotiinformatica.repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	private JdbcTemplate jdbcTemplate;

	public UsuarioRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Usuario obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuario obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Usuario obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getByEmailSenha(String email, String senha) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
