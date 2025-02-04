package br.com.dlima.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Acessorio;
import br.com.dlima.domain.Carro;
import br.com.dlima.domain.CarroAcessorio;
import br.com.dlima.domain.Marca;

public class CarroAcessorioDAOTest {
	private IGenericDAO<CarroAcessorio> dao;
	private IGenericDAO<Marca> daoMarca;
	private IGenericDAO<Carro> daoCarro;
	private IGenericDAO<Acessorio> daoAcessorio;
	
	public CarroAcessorioDAOTest() {
		this.dao = new CarroAcessorioDAO();
		this.daoMarca = new MarcaDAO();
		this.daoCarro = new CarroDAO();
		this.daoAcessorio  = new AcessorioDAO();
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
		Carro carro = this.daoCarro.cadastrar(c);
		
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		Acessorio acessorio = this.daoAcessorio.cadastrar(a);
		
		CarroAcessorio ca = new CarroAcessorio();
		ca.setAcessorio(acessorio);
		ca.setCarro(carro);
		CarroAcessorio carroAcessorio = this.dao.cadastrar(ca);
		
		
		assertNotNull(carroAcessorio.getId());
		dao.excluir(carroAcessorio);
		daoAcessorio.excluir(acessorio);
		daoCarro.excluir(carro);
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
		Carro carro = this.daoCarro.cadastrar(c);
		
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		Acessorio acessorio = this.daoAcessorio.cadastrar(a);
		
		CarroAcessorio ca = new CarroAcessorio();
		ca.setAcessorio(acessorio);
		ca.setCarro(carro);
		CarroAcessorio carroAcessorio = this.dao.cadastrar(ca);
		
		CarroAcessorio carroAcessorioBusca = this.dao.buscarPorId(carroAcessorio.getId());
		
		assertNotNull(carroAcessorioBusca);
		dao.excluir(carroAcessorio);
		daoAcessorio.excluir(acessorio);
		daoCarro.excluir(carro);
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
		Carro carro = this.daoCarro.cadastrar(c);
		
		Acessorio a = new Acessorio();
		a.setNome("Acessorio1");
		a.setCodigo("A1");
		Acessorio acessorio = this.daoAcessorio.cadastrar(a);
		
		CarroAcessorio ca = new CarroAcessorio();
		ca.setAcessorio(acessorio);
		ca.setCarro(carro);
		CarroAcessorio carroAcessorio = this.dao.cadastrar(ca);
		
		dao.excluir(carroAcessorio);
		CarroAcessorio carroAcessorioBusca = this.dao.buscarPorId(carroAcessorio.getId());
		
		assertEquals(carroAcessorioBusca, null);
		dao.excluir(carroAcessorio);
		daoAcessorio.excluir(acessorio);
		daoCarro.excluir(carro);
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
		Carro carro = this.daoCarro.cadastrar(c);
		
		Acessorio a1 = new Acessorio();
		a1.setNome("Acessorio1");
		a1.setCodigo("A1");
		Acessorio acessorio1 = this.daoAcessorio.cadastrar(a1);
		
		CarroAcessorio ca = new CarroAcessorio();
		ca.setAcessorio(acessorio1);
		ca.setCarro(carro);
		CarroAcessorio carroAcessorio = this.dao.cadastrar(ca);
		
		Acessorio a2 = new Acessorio();
		a2.setNome("Acessorio2");
		a2.setCodigo("A2");
		Acessorio acessorio2 = this.daoAcessorio.cadastrar(a2);
		
		ca.setAcessorio(acessorio2);
		
		CarroAcessorio carroAcessorioAlterar = dao.alterar(carroAcessorio);
		
		assertEquals(carroAcessorioAlterar.getAcessorio().getNome(), acessorio2.getNome());
		dao.excluir(carroAcessorio);
		daoAcessorio.excluir(acessorio1);
		daoAcessorio.excluir(acessorio2);
		daoCarro.excluir(carro);
		daoMarca.excluir(marca);
	}
	
	@Test
	public void buscarTodos() {
		Marca m = new Marca();
		m.setNome("Marca1");
		m.setCodigo("M1");
		Marca marca = this.daoMarca.cadastrar(m);
		
		Carro c = new Carro();
		c.setModelo("Carro1");
		c.setCodigo("C1");
		c.setMarca(marca);
		Carro carro = this.daoCarro.cadastrar(c);
		
		Acessorio a1 = new Acessorio();
		a1.setNome("Acessorio1");
		a1.setCodigo("A1");
		Acessorio acessorio1 = this.daoAcessorio.cadastrar(a1);
		
		Acessorio a2 = new Acessorio();
		a2.setNome("Acessorio2");
		a2.setCodigo("A2");
		Acessorio acessorio2 = this.daoAcessorio.cadastrar(a2);
		
		CarroAcessorio ca1 = new CarroAcessorio();
		ca1.setAcessorio(acessorio1);
		ca1.setCarro(carro);
		CarroAcessorio carroAcessorio1 = this.dao.cadastrar(ca1);
		
		CarroAcessorio ca2 = new CarroAcessorio();
		ca2.setAcessorio(acessorio2);
		ca2.setCarro(carro);
		CarroAcessorio carroAcessorio2 = this.dao.cadastrar(ca2);
		
		List<CarroAcessorio> CarrosAcessorios = dao.buscarTodos();
		
		assertEquals(CarrosAcessorios.size(), 2);
		dao.excluir(carroAcessorio1);
		dao.excluir(carroAcessorio2);
		daoAcessorio.excluir(acessorio1);
		daoAcessorio.excluir(acessorio2);
		daoCarro.excluir(carro);
		daoMarca.excluir(marca);
	}
}
















































