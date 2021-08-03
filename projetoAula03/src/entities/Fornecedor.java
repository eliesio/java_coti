package entities;

import java.util.List;

public class Fornecedor {

	private Integer idFornecedor;
	private String nome;
	private String cnpj;
	private List<Produto> produto;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(Integer idFornecedor, String nome, String cnpj) {
		super();
		this.idFornecedor = idFornecedor;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
