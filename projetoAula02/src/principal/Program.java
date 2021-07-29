package principal;

import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		// criando um objeto da classe Pessoa
				Pessoa pessoa = new Pessoa(1, "Sergio Mendes", "123.456.789-00");

				//imprimindo os dados de pessoa..
				System.out.println("\nDADOS DE PESSOA:\n");
				
				System.out.println("ID....: " + pessoa.getId());
				System.out.println("NOME..: " + pessoa.getNome());
				System.out.println("CPF...: " + pessoa.getCpf());
		
				
	}

}
