package principal;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class Program {

	public static void main(String[] args) {

		System.out.println("Dados do Funcionario:");

		Funcionario funcionario = new Funcionario();

		funcionario.setIdFuncionario(1);
		funcionario.setNome("Richard Pryor");
		funcionario.setCpf("123.456.789-00");
		funcionario.setMatricula("2021-001");
		funcionario.setSalario(3000.);

		System.out.println("\nDADOS DO FUNCIONARIO:");
		System.out.println("\tId do Funcionario......: " + funcionario.getIdFuncionario());
		System.out.println("\tNome do Funcionario....: " + funcionario.getNome());
		System.out.println("\tCPF do Funcionario.....: " + funcionario.getCpf());
		System.out.println("\tMatricula do Funcionario......: " + funcionario.getMatricula());
		System.out.println("\tSalario do Funcionario......: " + funcionario.getSalario());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

		try {

			funcionarioRepository.gravarArquivo(funcionario);
			System.out.println("\nDados gravados com sucesso!");
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
}
