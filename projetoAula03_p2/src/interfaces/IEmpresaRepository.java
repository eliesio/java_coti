package interfaces;

import entities.Empresa;

public interface IEmpresaRepository {

	// métodos abstratos
	void insert(Empresa empresa) throws Exception;

}