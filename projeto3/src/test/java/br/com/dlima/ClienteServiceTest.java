package br.com.dlima;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.ClienteDAO;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.ClienteService;
import br.com.dlima.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService service;
	
	private Cliente entity;

	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDAO();
		this.service = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		entity = new Cliente();
		entity.setCpf(12312312312L);
		entity.setNome("Rodrigo");
		entity.setCidade("São Paulo");
		entity.setEndereco("End");
		entity.setEstado("SP");
		entity.setTelefone("1199999999");
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = service.buscarPorCPF(entity.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = service.cadastrar(entity);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		service.excluir(entity.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		entity.setNome("Rodrigo Pires");
		service.alterar(entity);
		
		Assert.assertEquals("Rodrigo Pires", entity.getNome());
	}

}
