package br.com.dlima;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.dao.ProdutoDAO;
import br.com.dlima.domain.Produto;

public class ProdutoTest {
	private Produto produto;
	private IProdutoDAO dao;

	@Before
	public void setTests() {
		this.dao = new ProdutoDAO();
		this.produto = new Produto();
		
		this.produto.setQuantidade(20);
		this.produto.setNome("teste");
		this.produto.setDataCadastro(new Date());
	}
	
	@Test
	public void cadastrarTest() throws Exception {
		Integer cad = dao.cadastrar(produto);
		Assert.assertTrue(cad == 1);
		
		Produto produtoBusca = dao.consultar(this.produto.getNome());
		Assert.assertTrue(produtoBusca.getNome().equals(this.produto.getNome()));
		
		Integer exc = dao.excluir(produtoBusca.getId());
		Assert.assertTrue(exc == 1);
	}
}
