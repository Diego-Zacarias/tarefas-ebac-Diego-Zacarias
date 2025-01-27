/**
 * 
 */
package br.com.dlima.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dlima.domain.Matricula;

/**
 * 
 */
public class MatriculaDAO implements IMatriculaDAO {

	@Override
	public Matricula cadastrar(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(matricula);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}

	@Override
	public Matricula buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Matricula matricula = entityManager.find(Matricula.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}

	@Override
	public void excluir(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.remove(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public Matricula alterar(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
	}

	@Override
	public List<Matricula> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Matricula> list = 
				entityManager.createQuery("SELECT c FROM TB_MATRICULA c", Matricula.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}


}
