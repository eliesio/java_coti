package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Cliente;

public class ClienteRepository {
	
	public void gravarArquivo(Cliente cliente) throws Exception {
		
		PrintWriter printWriter = new PrintWriter
		 	  (new File ("/Users/Eliesio/Desktop/temp/cliente.txt"));
		
		printWriter.write("\nDADOS DO CLIENTE:");
		
		printWriter.write("\n\tId do Cliente......: "
				+ cliente.getIdCliente());
		
		printWriter.write("\n\tNome do Cliente....: "
				+ cliente.getNome());
		
		printWriter.write("\n\tEmail do Cliente...: "
				+ cliente.getEmail());
		
		printWriter.write("\n\tCPF do Cliente.....: "
				+ cliente.getCpf());
		
		printWriter.flush(); 
		
		printWriter.close();
	
	}

}
