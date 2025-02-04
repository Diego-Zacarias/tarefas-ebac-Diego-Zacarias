package br.com.dlima.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Acessorio;

public class AcessorioDAOTest {
private IGenericDAO<Acessorio> dao;
	
	public AcessorioDAOTest() {
		this.dao = new AcessorioDAO();
	}
	
	@Test
	public void cadastrar() {
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		
		Acessorio acessorio = this.dao.cadastrar(a);
		
		assertNotNull(acessorio.getId());
		dao.excluir(acessorio);
	}
	
	@Test
	public void buscarPorId() {
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		
		Acessorio acessorio = this.dao.cadastrar(a);
		Acessorio acessorioBusca = this.dao.buscarPorId(acessorio.getId());
		
		assertNotNull(acessorioBusca);
		dao.excluir(acessorio);
	}
	
	@Test
	public void excluir() {
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		
		Acessorio acessorio = this.dao.cadastrar(a);
		
		dao.excluir(acessorio);
		Acessorio acessorioBusca = this.dao.buscarPorId(acessorio.getId());
		
		assertEquals(acessorioBusca, null);
		
	}
	
	@Test
	public void alterar() {
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		
		Acessorio acessorio = this.dao.cadastrar(a);
		
		a.setNome("Acessorio2");
		
		Acessorio a2 = dao.alterar(acessorio);
		
		assertEquals(a2.getNome(), "Acessorio2");
		dao.excluir(a2);
	}
	
	@Test
	public void buscarTodos() {
		Acessorio a1 = new Acessorio();
		a1.setNome("Acessorio1");
		a1.setCodigo("A1");
		
		Acessorio acessorio1 = this.dao.cadastrar(a1);
		
		Acessorio a2 = new Acessorio();
		a2.setNome("Acessorio2");
		a2.setCodigo("A2");
		
		Acessorio acessorio2 = this.dao.cadastrar(a2);
		
		List<Acessorio> acessorios = dao.buscarTodos();
		
		assertEquals(acessorios.size(), 2);
		dao.excluir(acessorio1);
		dao.excluir(acessorio2);
	}
}
