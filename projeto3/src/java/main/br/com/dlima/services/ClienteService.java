package br.com.dlima.services;

import br.com.dlima.dao.ClienteDAO;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	IClienteDAO clienteDAO;
	public ClienteService(IGenericDAO<Cliente, Long> dao) {
		super(dao);
		this.clienteDAO = new ClienteDAO();
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void ativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.clienteDAO.ativarCliente(entity);
	}

	@Override
	public void inativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.clienteDAO.inativarCliente(entity);
	}

	@Override
	public void inadimplente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.clienteDAO.inadimplente(entity);
	}

}
