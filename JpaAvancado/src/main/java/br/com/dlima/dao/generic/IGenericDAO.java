package br.com.dlima.dao.generic;

import java.util.List;

public interface IGenericDAO<T> {
	public T cadastrar(T entity);
	
	public T buscarPorId(Long id);
	
	public void excluir(T entity);
	
	public T alterar(T entity);
	
	public List<T> buscarTodos();

}
