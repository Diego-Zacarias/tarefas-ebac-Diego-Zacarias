package br.com.dlima.services;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IService<Cliente> {
	
	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDao) {
		this.clienteDAO = clienteDao;
	}

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		try {
			return this.clienteDAO.cadastrar(entity);			
		} catch (Error e) {
			throw new TipoChaveNaoEncontradaException("Chave não localizada no objeto");
		}
	}

	@Override
	public void excluir(String chave) {
		this.clienteDAO.excluir(chave);
		
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		try {
			this.clienteDAO.alterar(entity);
		} catch (Error e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente consultar(String chave) {
		return this.clienteDAO.consultar(chave);
	}



}
