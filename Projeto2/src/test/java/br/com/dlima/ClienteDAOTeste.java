package br.com.dlima;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.ClienteDAO;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTeste {
	
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	public ClienteDAOTeste() {
		this.clienteDAO = new ClienteDAO();
	}
	
	@Before
	public void init() {
		
		this.cliente = new Cliente();
		cliente.setCidade("São Paulo");
		cliente.setCpf("12345678998");
		cliente.setEnd("rua primeira");
		cliente.setEstado("SP");
		cliente.setNome("Diego Lima");
		cliente.setNumero(2003);
		cliente.setTel("11988366457");
		
		try {
			clienteDAO.cadastrar(cliente);
		} catch (TipoChaveNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente newCliente = clienteDAO.consultar(this.cliente.getCpf());
		Assert.assertNotNull(newCliente);
	}
	
	@Test
	public void excluirTeste() {
		
	}

}
