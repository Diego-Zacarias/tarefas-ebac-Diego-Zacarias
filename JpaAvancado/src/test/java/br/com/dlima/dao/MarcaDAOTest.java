package br.com.dlima.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Marca;

public class MarcaDAOTest {
	
	private IGenericDAO<Marca> dao;
	
	public MarcaDAOTest() {
		this.dao = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		
		Marca marca = this.dao.cadastrar(m);
		
		assertNotNull(marca.getId());
		dao.excluir(marca);
	}
	
	@Test
	public void buscarPorId() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		
		Marca marca = this.dao.cadastrar(m);
		Marca buscaMarca = this.dao.buscarPorId(marca.getId());
		
		assertNotNull(buscaMarca);
		dao.excluir(marca);
	}
	
	@Test
	public void excluir() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		
		Marca marca = this.dao.cadastrar(m);
		
		dao.excluir(marca);
		Marca buscaMarca = this.dao.buscarPorId(marca.getId());
		
		assertEquals(buscaMarca, null);
		
	}
	
	@Test
	public void alterar() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		
		Marca marca = this.dao.cadastrar(m);
		
		m.setNome("Marca2");
		
		Marca m2 = dao.alterar(marca);
		
		assertEquals(m2.getNome(), "Marca2");
		dao.excluir(m2);
	}
	
	@Test
	public void buscarTodos() {
		Marca m1 = new Marca();
		m1.setNome("Marca1");
		m1.setCodigo("M1");
		
		Marca marca1 = this.dao.cadastrar(m1);
		
		Marca m2 = new Marca();
		m2.setNome("Marca2");
		m2.setCodigo("M2");
		
		Marca marca2 = this.dao.cadastrar(m2);
		
		List<Marca> marcas = dao.buscarTodos();
		
		assertEquals(marcas.size(), 2);
		dao.excluir(marca1);
		dao.excluir(marca2);
	}
}













































