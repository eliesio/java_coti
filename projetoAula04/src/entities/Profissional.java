package entities;

import enums.TipoContratacao;

public class Profissional {

	private Integer idProfissional;
	private String nome;
	private String cpf;
	private String telefone;
	private TipoContratacao tipoContratacao;
	
	public Profissional() {
		// TODO Auto-generated constructor stub
	}

	public Profissional(Integer idProfissional, String nome, String cpf, String telefone,
			TipoContratacao tipoContratacao) {
		super();
		this.idProfissional = idProfissional;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.tipoContratacao = tipoContratacao;
	}

	public Integer getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Integer idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoContratacao getTipoContratacao() {
		return tipoContratacao;
	}

	public void setTipoContratacao(TipoContratacao tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}
	
	
}
