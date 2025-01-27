package br.com.dlima;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.dlima.dao.CursoDAO;
import br.com.dlima.dao.ICursoDAO;
import br.com.dlima.domain.Curso;

public class CursoTest {

	private ICursoDAO cursoDAO;
	
	public CursoTest() {
		this.cursoDAO = new CursoDAO();
	}

	@Test
	public void cadastrar() {
		Curso c = new Curso();
		c.setCodigo("a1");
		c.setDescricao("descrição do curso");
		c.setNome("nome do curso");
		Curso curso = cursoDAO.cadastrar(c);
	
		assertNotNull(curso);
		assertNotNull(curso.getId());
		
	}
}
