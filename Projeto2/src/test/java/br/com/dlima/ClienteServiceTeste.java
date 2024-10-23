package br.com.dlima;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.ClienteDAOMock;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.ClienteService;
import br.com.dlima.services.IService;

/**
 * @author diego.lima
 *  
 */
public class ClienteServiceTeste {
	
	private Cliente cliente;
	private IService<Cliente> service;
	
	public ClienteServiceTeste() {
		IClienteDAO dao = new ClienteDAOMock();
		this.service = new ClienteService(dao);
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
	}
	
	private void cadastrarCliente() {
		try {
			this.service.cadastrar(this.cliente);
		} catch (TipoChaveNaoEncontradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void cadastrarTeste() {
		Boolean res;
		try {
			res = service.cadastrar(this.cliente);
			Assert.assertTrue(res);
		} catch (TipoChaveNaoEncontradaException e) {
			e.printStackTrace();
		}		
	}
	
    @Test(expected = TipoChaveNaoEncontradaException.class)
    public void ErroCadastrarTeste() throws TipoChaveNaoEncontradaException {
        this.service.cadastrar(new Cliente());
    }
	
	@Test
	public void excluirTeste() {
//		if (this.clienteService.consultar(cliente.getCpf()) == null) {
			this.cadastrarCliente();
//		}
		this.service.excluir(cliente.getCpf());
		Cliente excluido = this.service.consultar(cliente.getCpf());
		Assert.assertNull(excluido);
	}
	
	@Test
	public void alterarTeste() {
		this.cadastrarCliente();
		
		Cliente newCliente = new Cliente();
		newCliente.setCidade("new São Paulo");
		newCliente.setCpf("12345678998");
		newCliente.setEnd("new rua primeira");
		newCliente.setEstado("RJ");
		newCliente.setNome("Diego Lima");
		newCliente.setNumero(2003);
		newCliente.setTel("11988366457");
		try {
			this.service.alterar(newCliente);
		} catch (TipoChaveNaoEncontradaException e) {
			e.printStackTrace();
		}
		
		Cliente buscaCliente = this.service.consultar(cliente.getCpf());
		
		Assert.assertEquals(buscaCliente.getCidade(), newCliente.getCidade());
	}
	
	@Test
	public void consultarTeste() {
		this.cadastrarCliente();

		Cliente c = this.service.consultar(this.cliente.getCpf());
		
		Assert.assertEquals(c.getCpf(), cliente.getCpf());
	}
}
