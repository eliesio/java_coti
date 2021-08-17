package entities;

public class Servico {

	private Integer idServico;
	private String nome;
	private String descricao;
	private Double preco;

	public Servico() {
		// TODO Auto-generated constructor stub
	}

	public Servico(Integer idServico, String nome, String descricao, Double preco) {
		super();
		this.idServico = idServico;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
