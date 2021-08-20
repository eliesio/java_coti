package br.com.cotiinformatica.repositories;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.cotiinformatica.entities.Tarefa;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarefa getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarefa> getByDatas(Date dataMin, Date dataMax) {
		// TODO Auto-generated method stub
		return null;
	}

}


