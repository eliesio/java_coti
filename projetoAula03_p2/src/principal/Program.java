package principal;

import javax.swing.JOptionPane;

import entities.Empresa;
import repositories.EmpresaRepository;

public class Program {

	public static void main(String[] args) {

		try {
			System.out.println("\nCADASTRO DE EMPRESA\n");

			String nomeFantasia = JOptionPane.showInputDialog("Entre com o nome fantasia da empresa:");
			String razaoSocial = JOptionPane.showInputDialog("Entre com a razão social da empresa:");
			String cnpj = JOptionPane.showInputDialog("Entre com o CNPJ da empresa:");

			Empresa empresa = new Empresa();
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setCnpj(cnpj);

			EmpresaRepository empresaRepository = new EmpresaRepository();
			empresaRepository.insert(empresa);
			
			System.out.println("\nEMPRESA CADASTRADA COM SUCESSO!");

		} catch (Exception e) {

			System.out.println("\nErro: " + e.getMessage());

		}

	}

}
