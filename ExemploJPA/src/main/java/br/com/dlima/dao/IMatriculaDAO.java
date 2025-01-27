package br.com.dlima.dao;

import java.util.List;

import br.com.dlima.domain.Matricula;

public interface IMatriculaDAO {
	public Matricula cadastrar(Matricula matricula);
	
	public Matricula buscarPorID(Long id);

	public void excluir(Matricula matricula);

	public Matricula alterar(Matricula matricula);

	public List<Matricula> buscarTodos();
}
