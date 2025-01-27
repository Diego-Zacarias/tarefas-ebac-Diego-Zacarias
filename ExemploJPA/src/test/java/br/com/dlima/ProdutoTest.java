package br.com.dlima;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.dao.ProdutoDAO;
import br.com.dlima.domain.Produto;

public class ProdutoTest {
	private IProdutoDAO dao;
	
	public ProdutoTest() {
		this.dao = new ProdutoDAO();
	}
	
	@Test
	public void cadastrar() {
		Produto p = new Produto();
		p.setCodigo("P1");
		p.setNome("nome do produto");
		p.setDescricao("Descrição do produto");
		p.setValor(120.99);
		p.setAliquotaIcms(6.36);
		
		Produto produto = dao.cadastrar(p);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());
		
//		dao.excluir(produto);
	}
	
	@Test
	public void buscarPorID() {
		
	}
	
	@Test
	public void excluir() {
		
	}

	@Test
	public void alterar() {
		
	}

	@Test
	public void buscarTodos() {
		
	}
	
	
}
