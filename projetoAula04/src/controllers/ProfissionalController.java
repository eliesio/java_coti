package controllers;

import entities.Profissional;
import inputs.ProfissionalInput;
import interfaces.IProfissionalRepository;

public class ProfissionalController {

	// atributo
	private IProfissionalRepository profissionalRepository;

	// construtor para receber a instancia da interface..
	public ProfissionalController(IProfissionalRepository profissionalRepository) {
		this.profissionalRepository = profissionalRepository;
	}

	// método para fazer a exportação dos dados de
	// um profisisonal para um repositorio de arquivo
	public void executarExportacao() throws Exception {

		// criando uma instancia da classe Profissional
		Profissional profissional = new Profissional();

		profissional.setIdProfissional(ProfissionalInput.lerIdProfissional());
		profissional.setNome(ProfissionalInput.lerNome());
		profissional.setCpf(ProfissionalInput.lerCpf());
		profissional.setTelefone(ProfissionalInput.lerTelefone());
		profissional.setTipoContratacao(ProfissionalInput.lerTipoContratacao());

		profissionalRepository.exportarDados(profissional);
	}
}
