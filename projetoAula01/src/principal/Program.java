package principal;

import entities.Cliente;

import repositories.ClienteRepository;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Aula 01 - JAVA DEVELOPER");
		
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1);
		cliente.setNome("Sergio Mendes");
		cliente.setEmail("sergio.coti@gmail.com");
		cliente.setCpf("123.456.789-00");
		
		System.out.println("\nDADOS DO CLIENTE:"); 
		
		System.out.println("\tId do Cliente......: "
				+ cliente.getIdCliente()); 
		
		System.out.println("\tNome do Cliente....: "
				+ cliente.getNome()); 
		
		System.out.println("\tEmail do Cliente...: "
				+ cliente.getEmail());
				
		System.out.println("\tCPF do Cliente.....: "
				+ cliente.getCpf());
		
		ClienteRepository clienteRepository
			= new ClienteRepository();
					
			
		try {
				clienteRepository.gravarArquivo(cliente);
				System.out.println("\\nDados gravados com sucesso!");			
		}
		
		catch(Exception e) {
			System.out.println("\nErro ao gravar arquivo!");
			System.out.println(e.getMessage());
		}
	
	}

}
