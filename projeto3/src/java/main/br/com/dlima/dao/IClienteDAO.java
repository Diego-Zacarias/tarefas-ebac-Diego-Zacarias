package br.com.dlima.dao;

import java.util.Collection;

import br.com.dlima.domain.Cliente;

public interface IClienteDAO {
	public Integer cadastrar(Cliente entity) throws Exception;
	public Cliente consultar(String codigo) throws Exception;
	public Integer excluir(String id) throws Exception;
	public Integer alterar(Cliente newEntity, String oldId) throws Exception;
	public Collection<Cliente> buscarTodos() throws Exception;
}
