package br.com.dlima.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.dlima.domain.Persistente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDAO<T extends Persistente, E extends Serializable> {
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void excluir(E valor) throws DAOException;
	
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;
	
	public Collection<T> buscarTodos() throws DAOException;
}
