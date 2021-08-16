package principal;

import entities.Cliente;
import entities.Endereco;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa(1, "Richar", "Pryor");

		Cliente cliente = new Cliente("123.456.789-00", "rpryor@gmail.com", "2121696969");

		Endereco endereco = new Endereco(1, "est. da agua grande", "bloco 6 apto 204", "221", "iraja", "rio de janeiro",
				"rj", "21230362");

		System.out.println("\nDADOS DE PESSOA");
		System.out.println("ID..........: " + pessoa.getId());
		System.out.println("NOME........: " + pessoa.getNome());
		System.out.println("SOBRENOME...: " + pessoa.getSobrenome());
		System.out.println("CPF.........: " + cliente.getCpf());
		System.out.println("EMAIL.......: " + cliente.getEmail());
		System.out.println("TEL.........: " + cliente.getTelefone());
		System.out.println("LOGRADOURO..: " + endereco.getLogradouro());
		System.out.println("COMPLEMENTO.: " + endereco.getComplemento());
		System.out.println("NUMERO......: " + endereco.getNumero());
		System.out.println("BAIRRO......: " + endereco.getBairro());
		System.out.println("CIDADE......: " + endereco.getCidade());
		System.out.println("ESTADO......: " + endereco.getEstado());
		System.out.println("CEP.........: " + endereco.getCep());

	}

}
