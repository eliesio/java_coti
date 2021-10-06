package br.com.cotiinformatica.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePostRequest {

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
}
