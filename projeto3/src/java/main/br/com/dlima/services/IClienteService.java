package br.com.dlima.services;

import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
	
	Cliente buscarPorCPF(Long cpf) throws DAOException;
	public void ativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
	public void inativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
	public void inadimplente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException;
}
