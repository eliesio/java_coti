package br.com.cotiinformatica.entities;

import java.util.Date;

import br.com.cotiinformatica.enums.PrioridadeTarefa;

public class Tarefa {

	private Integer idTarefa;
	private String nome;
	private Date data;
	private String hora;
	private String descricao;
	private PrioridadeTarefa prioridade;

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer idTarefa, String nome, Date data, String hora, String descricao,
			PrioridadeTarefa prioridade) {
		super();
		this.idTarefa = idTarefa;
		this.nome = nome;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PrioridadeTarefa getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeTarefa prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", nome=" + nome + ", data=" + data + ", hora=" + hora + ", descricao="
				+ descricao + ", prioridade=" + prioridade + "]";
	}

}