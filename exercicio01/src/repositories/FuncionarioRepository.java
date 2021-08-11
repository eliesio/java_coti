package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Funcionario;

public class FuncionarioRepository {

	public void gravarArquivo(Funcionario funcionario) throws Exception {
	
	PrintWriter printWriter = new PrintWriter  (new File("/Users/Eliesio/Desktop/temp/" + "funcionario.txt"));
	
	printWriter.write("\nDADOS DO FUNCIONARIO:");
	printWriter.write("\n\tId do Funcionario......: " + funcionario.getIdFuncionario());
	printWriter.write("\n\tNome do Funcionario....: " + funcionario.getNome());
	printWriter.write("\n\tCPF do Funcionario.....: " + funcionario.getCpf());
	printWriter.write("\n\tMatricula do Funcionario.....: " + funcionario.getMatricula());
	printWriter.write("\n\tSalario do Funcionario.....: " + funcionario.getSalario());
	printWriter.flush();
	printWriter.close();	
	
	}
}