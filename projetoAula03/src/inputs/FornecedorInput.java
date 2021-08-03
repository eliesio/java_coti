package inputs;

import javax.swing.JOptionPane;

public class FornecedorInput {

	// m�todo para que o usuario entre com o id do fornecedor
	public static Integer lerIdFornecedor() throws Exception {

		Integer idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id do fornecedor:"));
		
		//Regra: o id do fornecedor deve ser um valor maior do que zero
		if(idFornecedor > 0) {
			return idFornecedor; // retornando o valor da variavel..
		}
		else {
			//gerar uma exce��o (erro, ou seja, executar o bloco catch)
			throw new Exception("O id do fornecedor deve ser maior do que zero.");
		}		
	}

	// m�todo para que o usuario entre com o nome do fornecedor
	public static String lerNome() throws Exception {

		String nome = JOptionPane.showInputDialog("Entre com o nome do fornecedor:");
		return nome; // retornando o valor da vari�vel..
	}

	// m�todo para que o usuario entre com o cnpj do fornecedor
	public static String lerCnpj() throws Exception {

		String cnpj = JOptionPane.showInputDialog("Entre com o cnpj do fornecedor:");
		return cnpj; // retornando o valor da variavel..
	}

}