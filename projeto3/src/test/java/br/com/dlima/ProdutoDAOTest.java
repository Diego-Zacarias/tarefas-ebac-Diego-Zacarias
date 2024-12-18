package br.com.dlima;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.dao.ProdutoDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {
	private IProdutoDAO dao;

	public ProdutoDAOTest() {
		this.dao = new ProdutoDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Produto> list = dao.buscarTodos();
		list.forEach(prod -> {
			try {
				dao.excluir(prod.getCodigo());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		dao.cadastrar(produto);
		return produto;
	}
	
	private void excluir(String valor) throws DAOException {
		this.dao.excluir(valor);
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Produto produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		Produto produtoDB = this.dao.consultar(produto.getCodigo());
		Assert.assertNotNull(produtoDB);
		excluir(produtoDB.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = criarProduto("A2");
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
		Produto produtoBD = this.dao.consultar(produto.getCodigo());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4");
		produto.setNome("Rodrigo Pires");
		dao.alterar(produto);
		Produto produtoBD = this.dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());
		
		excluir(produto.getCodigo());
		Produto produtoBD1 = this.dao.consultar(produto.getCodigo());
		assertNull(produtoBD1);
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<Produto> list = dao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (Produto prod : list) {
			excluir(prod.getCodigo());
		}
		
		list = dao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
	
}













































