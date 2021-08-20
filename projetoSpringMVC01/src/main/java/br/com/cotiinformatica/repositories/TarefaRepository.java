package br.com.cotiinformatica.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

public class TarefaRepository implements ITarefaRepository {

	//atributo
	private JdbcTemplate jdbcTemplate;
	
	//construtor para receber a conexão com o banco de dados (definida no DataSource)
	//e inicializar o atributo jdbcTemplate
	public TarefaRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(Tarefa obj) throws Exception {

		String query = "insert into tarefa(nome, data, hora, descricao, prioridade) values(?, ?, ?, ?, ?)";

		Object[] params = {
			obj.getNome(),
			obj.getData(),
			obj.getHora(),
			obj.getDescricao(),
			obj.getPrioridade()
		};

		jdbcTemplate.update(query, params);
	}

	@Override
	public void update(Tarefa obj) throws Exception {

		String query = "update tarefa set nome=?, data=?, hora=?, descricao=?, prioridade=? where idtarefa=?";

		Object[] params = {
			obj.getNome(),
			obj.getData(),
			obj.getHora(),
			obj.getDescricao(),
			obj.getPrioridade(),
			obj.getIdTarefa()
		};

		jdbcTemplate.update(query, params);
	}

	@Override
	public void delete(Tarefa obj) throws Exception {

		String query = "delete from tarefa where idtarefa=?";

		Object[] params = {
			obj.getIdTarefa()
		};

		jdbcTemplate.update(query, params);

	}

	@Override
	public List<Tarefa> getAll() throws Exception {

		String query = "select * from tarefa order by data desc";
		
		List<Tarefa> lista = jdbcTemplate.query(query, new RowMapper<Tarefa>() {

			@Override
			public Tarefa mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getTarefa(rs);
			}			
		});
		
		return lista;
	}

	@Override
	public Tarefa getById(Integer id) throws Exception {

		String query = "select * from tarefa where idtarefa=?";
		
		Object[] params = { id };
		
		List<Tarefa> lista = jdbcTemplate.query(query, params, new RowMapper<Tarefa>() {

			@Override
			public Tarefa mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getTarefa(rs);
			}			
		});
		
		if( ! lista.isEmpty()) //se a lista não está vazia
			return lista.get(0); //retorne o primeiro elemento da lista
		
		return null;
	}

	@Override
	public List<Tarefa> getByDatas(Date dataMin, Date dataMax) throws Exception{

		String query = "select * from tarefa where data between ? and ? order by data desc";
		
		Object[] params = { dataMin, dataMax };
		
		List<Tarefa> lista = jdbcTemplate.query(query, params, new RowMapper<Tarefa>() {

			@Override
			public Tarefa mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getTarefa(rs);
			}			
		});		
		
		return lista;		
	}
	
	
	//método somente para ler os dados da tarefa na consulta do banco de dados
	private Tarefa getTarefa(ResultSet rs) throws SQLException {
		
		Tarefa tarefa = new Tarefa();
		
		tarefa.setIdTarefa(rs.getInt("idtarefa"));
		tarefa.setNome(rs.getString("nome"));
		tarefa.setData(rs.getDate("data"));
		tarefa.setHora(rs.getString("hora"));
		tarefa.setDescricao(rs.getString("descricao"));
		tarefa.setPrioridade(PrioridadeTarefa.valueOf(rs.getString("prioridade")));
		
		return tarefa;		
	}	
}








