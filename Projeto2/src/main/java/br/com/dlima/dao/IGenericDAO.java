package br.com.dlima.dao;

import java.util.Collection;

import br.com.dlima.domain.Persistente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDAO<T extends Persistente> {

	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
	
	public void excluir(String chave);
	
	public void alterar(T entity) throws TipoChaveNaoEncontradaException;
	
	public T consultar(String chave);
	
	public Collection<T> buscarTodos();
}
