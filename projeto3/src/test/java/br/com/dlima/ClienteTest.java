package br.com.dlima;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.ClienteDAO;
import br.com.dlima.dao.IClienteDAO;
import br.com.dlima.domain.Cliente;

public class ClienteTest {
	
	private Cliente cliente;
	private IClienteDAO dao;

	@Before
	public void setTests() {
		this.dao = new ClienteDAO();
		this.cliente = new Cliente();
		
		this.cliente.setCodigo("01");
		this.cliente.setNome("teste");
		this.cliente.setDataCadastro(new Date());
	}
	
	@Test
	public void cadastrarTest() throws Exception {
		Integer cad = dao.cadastrar(cliente);
		Assert.assertTrue(cad == 1);
		
		Cliente clienteBusca = dao.consultar(this.cliente.getCodigo());
		Assert.assertTrue(clienteBusca.getCodigo().equals("01"));
		
		Integer exc = dao.excluir(clienteBusca.getId());
		Assert.assertTrue(exc == 1);
	}
}
