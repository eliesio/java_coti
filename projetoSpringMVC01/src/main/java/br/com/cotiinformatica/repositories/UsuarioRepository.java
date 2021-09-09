package br.com.cotiinformatica.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	private JdbcTemplate jdbcTemplate;

	public UsuarioRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Usuario obj) throws Exception {

		String query = "insert into usuario(nome, email, senha) values(?, ?, md5(?))";

		Object[] params = { obj.getNome(), obj.getEmail(), obj.getSenha() };

		jdbcTemplate.update(query, params);
	}

	@Override
	public void update(Usuario obj) throws Exception {

		String query = "update usuario set nome = ?, email = ?, senha = md5(?) where idusuario = ?";

		Object[] params = { obj.getNome(), obj.getEmail(), obj.getSenha(), obj.getIdUsuario() };

		jdbcTemplate.update(query, params);
	}

	@Override
	public void delete(Usuario obj) throws Exception {

		String query = "delete from usuario where idusuario = ?";

		Object[] params = { obj.getIdUsuario() };

		jdbcTemplate.update(query, params);
	}

	@Override
	public List<Usuario> getAll() throws Exception {

		String query = "select * from usuario";

		List<Usuario> lista = jdbcTemplate.query(query, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});

		return lista;

	}

	@Override
	public Usuario getById(Integer id) throws Exception {

		String query = "select * from usuario where idusuario = ?";

		Object[] params = { id };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});

		if (!lista.isEmpty()) // se a lista não está vazia
			return lista.get(0); // retorne o primeiro elemento da lista

		return null;
	}

	@Override
	public Usuario getByEmail(String email) throws Exception {

		String query = "select * from usuario where email = ?";

		Object[] params = { email };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});

		if (!lista.isEmpty()) // se a lista não está vazia
			return lista.get(0); // retorne o primeiro elemento da lista

		return null;
	}

	@Override
	public Usuario getByEmailSenha(String email, String senha) throws Exception {

		String query = "select * from usuario where email = ? and senha = md5(?)";

		Object[] params = { email, senha };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});

		if (!lista.isEmpty()) // se a lista não está vazia
			return lista.get(0); // retorne o primeiro elemento da lista

		return null;

	}

	// método somente para ler os dados da tarefa na consulta do banco de dados
	private Usuario getUsuario(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setIdUsuario(rs.getInt("idusuario"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));

		return usuario;
	}

}





