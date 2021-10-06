package br.com.cotiinformatica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // definindo a classe como uma entidade de banco de dados
@Table(name = "tb_cliente") // define o nome da tabela no banco de dados
@Setter // gerando os métodos 'set'
@Getter // gerando os métodos 'get'
@NoArgsConstructor // gerando o construtor default (vazio)
@AllArgsConstructor // gerando o construtor com entrada de argumentos
@ToString // gerando o método toString
public class Cliente {

	@Id // define a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Integer idCliente;

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 15, nullable = false, unique = true)
	private String cpf;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
}
