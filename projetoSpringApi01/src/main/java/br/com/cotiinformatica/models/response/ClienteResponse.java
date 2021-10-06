package br.com.cotiinformatica.models.response;

import br.com.cotiinformatica.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

	private Integer status;
	private String mensagem;
	private Cliente cliente;

}