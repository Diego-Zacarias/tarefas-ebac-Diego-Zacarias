package br.com.dlima;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.IService;
import br.com.dlima.dao.ProdutoDAO;
import br.com.dlima.services.ProdutoService;

public class ProdutoServiceTeste {
	private Produto produto;
	private IService<Produto> service;
	
	public ProdutoServiceTeste() {
		IProdutoDAO dao = new ProdutoDAO();
		this.service = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		
		this.produto = new Produto();
		produto.setCodigo("produto1");
		produto.setDescricao("Produto 1");
		produto.setPreco(9.99f);
		produto.setQuantidade(100);
	}
	
	private void cadastrarCliente() {
		try {
			this.service.cadastrar(this.produto);
		} catch (TipoChaveNaoEncontradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void cadastrarTeste() {
		if (this.service.consultar(produto.getCodigo()) != null) {
			this.service.excluir(produto.getCodigo());
		}
		Boolean res;
		try {
			res = service.cadastrar(this.produto);
			Assert.assertTrue(res);
		} catch (TipoChaveNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void excluirTeste() {
//		if (this.clienteService.consultar(cliente.getCpf()) == null) {
			this.cadastrarCliente();
//		}
		this.service.excluir(produto.getCodigo());
		Produto excluido = this.service.consultar(this.produto.getCodigo());
		Assert.assertNull(excluido);
	}
	
	@Test
	public void alterarTeste() {
		this.cadastrarCliente();
		
		Produto newProduto = new Produto();
		newProduto.setCodigo("produto1");
		newProduto.setDescricao("Produto 1");
		newProduto.setPreco(9.99f);
		newProduto.setQuantidade(80);
		try {
			this.service.alterar(newProduto);
		} catch (TipoChaveNaoEncontradaException e) {
			e.printStackTrace();
		}
		
		Produto buscaProduto = this.service.consultar(this.produto.getCodigo());
		
		Assert.assertEquals(buscaProduto.getQuantidade(), newProduto.getQuantidade());
	}
	
	@Test
	public void consultarTeste() {
		this.cadastrarCliente();

		Produto p = this.service.consultar(this.produto.getCodigo());
		
		Assert.assertEquals(p.getCodigo(), this.produto.getCodigo());
	}
	
}
