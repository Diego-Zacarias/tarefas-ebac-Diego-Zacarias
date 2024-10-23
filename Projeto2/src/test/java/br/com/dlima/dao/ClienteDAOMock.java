package br.com.dlima.dao;

import java.util.Collection;

import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		if (entity.equals(null)) {
			throw new TipoChaveNaoEncontradaException("Chave não localizada no ");
		}
		return true;
	}

	@Override
	public void excluir(String chave) {
		
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		
	}

	@Override
	public Cliente consultar(String chave) {
		Cliente cliente = new Cliente();
		cliente.setCpf(chave);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
