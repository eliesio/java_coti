package entities;

public class Cliente extends Pessoa {

	private String cpf;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String cpf, String email, String telefone) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
