package inputs;

import javax.swing.JOptionPane;

public class FornecedorInput {

	// método para que o usuario entre com o id do fornecedor
	public static Integer lerIdFornecedor() throws Exception {

		Integer idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id do fornecedor:"));
		return idFornecedor; // retornando o valor da variavel..
	}

	// método para que o usuario entre com o nome do fornecedor
	public static String lerNome() throws Exception {

		String nome = JOptionPane.showInputDialog("Entre com o nome do fornecedor:");
		return nome; // retornando o valor da variável..
	}

	// método para que o usuario entre com o cnpj do fornecedor
	public static String lerCnpj() throws Exception {

		String cnpj = JOptionPane.showInputDialog("Entre com o cnpj do fornecedor:");
		return cnpj; // retornando o valor da variavel..
	}

}