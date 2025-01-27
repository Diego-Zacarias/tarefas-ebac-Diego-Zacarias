/**
 * 
 */
package br.com.dlima.dao;

import java.util.List;

import br.com.dlima.domain.Curso;

/**
 * 
 */
public interface ICursoDAO {
	public Curso cadastrar(Curso curso);
	
	public Curso buscarPorID(Long id);

	public void excluir(Curso cliente);

	public Curso alterar(Curso cliente);

	public List<Curso> buscarTodos();
}
