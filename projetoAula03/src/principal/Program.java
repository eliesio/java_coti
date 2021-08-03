package principal;

import entities.Fornecedor;
import inputs.FornecedorInput;

public class Program {

	public static void main(String[] args) {

		//Criando objeto para a classe Fornecedor..
		Fornecedor fornecedor = new Fornecedor();

		try {
			
			fornecedor.setIdFornecedor(FornecedorInput.lerIdFornecedor());
			fornecedor.setNome(FornecedorInput.lerNome());
			fornecedor.setCnpj(FornecedorInput.lerCnpj());
			
			//imprimindo os dados
			System.out.println("\nDADOS DO FORNECEDOR:\n");
			System.out.println("\tId do fornecedor.: " + fornecedor.getIdFornecedor());
			System.out.println("\tNome.............: " + fornecedor.getNome());
			System.out.println("\tCNPJ.............: " + fornecedor.getCnpj());
		}
		catch(Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}