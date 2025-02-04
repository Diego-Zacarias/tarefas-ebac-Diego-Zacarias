package br.com.dlima.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.List;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Carro;
import br.com.dlima.domain.Marca;

public class CarroDAOTest {
	
	private IGenericDAO<Carro> dao;
	private IGenericDAO<Marca> daoMarca;
	
	public CarroDAOTest() {
		this.dao = new CarroDAO();
		this.daoMarca = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		Marca marca = this.daoMarca.cadastrar(m);
		
		Carro c = new Carro();
		c.setModelo("Carro1");
		c.setCodigo("C1");
		c.setMarca(marca);
		
		Carro carro = this.dao.cadastrar(c);
		
		assertNotNull(carro.getId());
		dao.excluir(carro);
		daoMarca.excluir(marca);
	}
	
	@Test
	public void buscarPorId() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		Marca marca = this.daoMarca.cadastrar(m);
		
		Carro c = new Carro();
		c.setModelo("Carro1");
		c.setCodigo("C1");
		c.setMarca(marca);
		
		Carro carro = this.dao.cadastrar(c);
		
		Carro carroBusca = this.dao.buscarPorId(carro.getId());
		
		assertNotNull(carroBusca);
		dao.excluir(carro);
		daoMarca.excluir(marca);
	}
	
	@Test
	public void excluir() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		Marca marca = this.daoMarca.cadastrar(m);
		
		Carro c = new Carro();
		c.setModelo("Carro1");
		c.setCodigo("C1");
		c.setMarca(marca);
		
		Carro carro = this.dao.cadastrar(c);
		
		dao.excluir(carro);
		Carro carroBusca = this.dao.buscarPorId(carro.getId());
		
		assertEquals(carroBusca, null);
		daoMarca.excluir(marca);
		
	}
	
	@Test
	public void alterar() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		Marca marca = this.daoMarca.cadastrar(m);
		
		Carro c = new Carro();
		c.setModelo("Carro1");
		c.setCodigo("C1");
		c.setMarca(marca);
		
		Carro carro = this.dao.cadastrar(c);
		
		c.setModelo("Carro2");
		
		Carro c2 = dao.alterar(carro);
		
		assertEquals(c2.getModelo(), "Carro2");
		dao.excluir(c2);
		daoMarca.excluir(marca);
	}
	
	@Test
	public void buscarTodos() {
		Marca m1 = new Marca();
		m1.setNome("Marca1");
		m1.setCodigo("M1");
		Marca marca1 = this.daoMarca.cadastrar(m1);
		
		Carro c1 = new Carro();
		c1.setModelo("Carro1");
		c1.setCodigo("C1");
		c1.setMarca(marca1);
		
		Marca m2 = new Marca();
		m2.setNome("Marca2");
		m2.setCodigo("M2");
		Marca marca2 = this.daoMarca.cadastrar(m2);
		
		Carro c2 = new Carro();
		c2.setModelo("Carro2");
		c2.setCodigo("C2");
		c2.setMarca(marca2);
		
		Carro carro1 = this.dao.cadastrar(c1);
		Carro carro2 = this.dao.cadastrar(c2);
		
		List<Carro> Carros = dao.buscarTodos();
		
		assertEquals(Carros.size(), 2);
		dao.excluir(carro1);
		dao.excluir(carro2);
		daoMarca.excluir(marca1);
		daoMarca.excluir(marca2);
	}
}


























