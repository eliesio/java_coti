package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entities.Empresa;
import interfaces.IEmpresaRepository;

public class EmpresaRepository implements IEmpresaRepository {

	@Override
	public void insert(Empresa empresa) throws Exception {

		// Conectar-se no banco de dados (MYSQL)
		String url = "jdbc:mysql://localhost:3306/bd_projetoaula03?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "coti";

		// abrindo uma conexão com o MYSQL
		Connection connection = DriverManager.getConnection(url, user, password);

		// escrevendo o comando SQL para cadastrar uma empresa
		String query = "insert into empresa(nomefantasia, razaosocial, cnpj) values(?, ?, ?)";

		// executando o comando SQL
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, empresa.getNomeFantasia());
		statement.setString(2, empresa.getRazaoSocial());
		statement.setString(3, empresa.getCnpj());
		statement.execute();

		// fechando as conexões
		statement.close();
		connection.close();
	}

}
