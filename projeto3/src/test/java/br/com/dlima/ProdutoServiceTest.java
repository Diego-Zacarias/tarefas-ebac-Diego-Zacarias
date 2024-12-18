package br.com.dlima;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.dao.ProdutoDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.IProdutoService;
import br.com.dlima.services.ProdutoService;

public class ProdutoServiceTest {
	private IProdutoService service;
	
	private Produto entity;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDAO();
		service = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		entity = new Produto();
		entity.setCodigo("A1");
		entity.setDescricao("Produto 1");
		entity.setNome("Produto 1");
		entity.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.service.consultar(entity.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = service.cadastrar(entity);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		service.excluir(entity.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		entity.setNome("Rodrigo Pires");
		service.alterar(entity);
		
		Assert.assertEquals("Rodrigo Pires", entity.getNome());
	}
}
