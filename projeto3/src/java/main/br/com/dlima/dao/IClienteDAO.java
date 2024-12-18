package br.com.dlima.dao;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {
	public void ativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
	public void inativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
	public void inadimplente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
}
