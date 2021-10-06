package br.com.cotiinformatica.models.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientePutRequest {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
}
