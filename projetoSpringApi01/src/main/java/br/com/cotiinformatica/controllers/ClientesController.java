package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.models.request.ClientePostRequest;
import br.com.cotiinformatica.models.request.ClientePutRequest;
import br.com.cotiinformatica.models.response.ClienteResponse;
import br.com.cotiinformatica.repositories.IClienteRepository;

@Controller // classe de controle do Spring Boot
@Transactional // habilitar o controle a executar transações no banco de dados
public class ClientesController {

	// definir o ENDPOINT do serviço
	// atributo de valor constante
	private static final String ENDPOINT = "/api/clientes";

	/*
	 * Define o repositorio que será utilizado pelo controlador
	 * 
	 * @Autowired -> faz com que o Spring inicialize o repositorio de forma
	 * automática
	 */
	@Autowired
	private IClienteRepository clienteRepository;

	// método para gerar um serviço de cadastro de clientes
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ClienteResponse> post(@RequestBody ClientePostRequest request) {

		ClienteResponse response = new ClienteResponse();

		try {

			// testar se o email informado já está cadastrado no banco de dados
			if (clienteRepository.findByEmail(request.getEmail()) != null)
				throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");

			// testar se o cpf informado já está cadastrado no banco de dados
			if (clienteRepository.findByCpf(request.getCpf()) != null)
				throw new IllegalArgumentException("O cpf informado já está cadastrado, tente outro.");

			// criando um objeto cliente a partir dos dados recebidos..
			Cliente cliente = new Cliente();

			cliente.setNome(request.getNome());
			cliente.setEmail(request.getEmail());
			cliente.setCpf(request.getCpf());
			cliente.setTelefone(request.getTelefone());

			clienteRepository.save(cliente);

			response.setStatus(HttpStatus.CREATED.value()); // HTTP 201
			response.setMensagem("Cliente cadastrado com sucesso.");
			response.setCliente(cliente);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (IllegalArgumentException e) {

			response.setStatus(HttpStatus.BAD_REQUEST.value()); // HTTP 400
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	// método para gerar um serviço de edição de clientes
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ClienteResponse> put(@RequestBody ClientePutRequest request) {

		try {

			ClienteResponse response = new ClienteResponse();

			// buscando o cliente no banco de dados atraves do id
			Optional<Cliente> item = clienteRepository.findById(request.getIdCliente());

			// verificar se o cliente não existe na base de dados
			if (item.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setMensagem("Cliente não encontrado");

				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}

			// retornar os dados do cliente..
			Cliente cliente = item.get();

			// verificando se o email informado na edição pertence a outro cliente na base
			Cliente consultaPorEmail = clienteRepository.findByEmail(request.getEmail());
			if (consultaPorEmail != null && consultaPorEmail.getIdCliente() != cliente.getIdCliente()) {
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				response.setMensagem("O email informado já está cadastrado para outro cliente.");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			// verificando se o cpf informado na edição pertence a outro cliente na base
			Cliente consultaPorCpf = clienteRepository.findByCpf(request.getCpf());
			if (consultaPorCpf != null && consultaPorCpf.getIdCliente() != cliente.getIdCliente()) {
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				response.setMensagem("O cpf informado já está cadastrado para outro cliente.");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			// modificando os dados do cliente
			cliente.setNome(request.getNome());
			cliente.setEmail(request.getEmail());
			cliente.setCpf(request.getCpf());
			cliente.setTelefone(request.getTelefone());

			// atualizando o cliente na base de dados
			clienteRepository.save(cliente);

			response.setStatus(HttpStatus.OK.value()); // HTTP 201
			response.setMensagem("Cliente atualizado com sucesso.");
			response.setCliente(cliente);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	// método para gerar um serviço de exclusão de clientes
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ClienteResponse> delete(@PathVariable("id") Integer id) {

		try {

			ClienteResponse response = new ClienteResponse();

			// buscando o cliente no banco de dados atraves do id
			Optional<Cliente> item = clienteRepository.findById(id);

			// verificar se o cliente não existe na base de dados
			if (item.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setMensagem("Cliente não encontrado");

				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}

			// recuperar os dados do cliente
			Cliente cliente = item.get();
			// excluindo o cliente no banco de dados
			clienteRepository.delete(cliente);

			response.setStatus(HttpStatus.OK.value()); // HTTP 201
			response.setMensagem("Cliente excluído com sucesso.");
			response.setCliente(cliente);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	// método para gerar um serviço de consulta de clientes
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Cliente>> getAll() {

		try {

			// consultar todos os clientes cadastrados na base de dados
			List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
			// retornando o resultado da consulta
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

	// método para gerar um serviço de consulta de 1 cliente atraves do id
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Cliente> getById(@PathVariable("id") Integer id) {

		try {

			//buscar o cliente no banco de dados atraves do id
			Optional<Cliente> item = clienteRepository.findById(id);

			//verificar se nenhum cliente foi encontrado
			if(item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			
			//obter os dados do cliente
			Cliente cliente = item.get();
			
			//retornando os dados do cliente encontrado
			return ResponseEntity.status(HttpStatus.OK).body(cliente);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}
}
