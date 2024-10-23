package br.com.dlima.services;

import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public interface IService<T> {

	Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
	
	void excluir(String chave);
	
	void alterar(T entity) throws TipoChaveNaoEncontradaException;
	
	T consultar(String chave);

}
