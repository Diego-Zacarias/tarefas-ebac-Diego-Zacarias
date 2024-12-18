package br.com.dlima;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.dlima.dao.ClienteDAO;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
	private IClienteDAO dao;
	
	public ClienteDAOTest() {
		dao = new ClienteDAO();
	}

	@After
	public void end() throws DAOException {
		Collection<Cliente> list = dao.buscarTodos();
		list.forEach(cli -> {
			try {
				dao.excluir(cli.getCpf());
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setTelefone("1199999999");
		dao.cadastrar(cliente);
		
		Cliente clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		dao.excluir(cliente.getCpf());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setTelefone("1199999999");
		Boolean retorno = dao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		dao.excluir(cliente.getCpf());
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setTelefone("1199999999");
		Boolean retorno = dao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		dao.excluir(cliente.getCpf());
		clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setTelefone("1199999999");
		Boolean retorno = dao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		dao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = dao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		dao.excluir(cliente.getCpf());
		clienteConsultado = dao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setTelefone("1199999999");
		Boolean retorno = dao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf(56565656569L);
		cliente1.setNome("Rodrigo");
		cliente1.setCidade("São Paulo");
		cliente1.setEndereco("End");
		cliente1.setEstado("SP");
		cliente1.setTelefone("1199999999");
		Boolean retorno1 = dao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);
		
		Collection<Cliente> list = dao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				dao.excluir(cli.getCpf());
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = dao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}
