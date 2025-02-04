package br.com.dlima.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> implements IGenericDAO<T> {
	
	public abstract Class<T> getTipoClasse();
	
	protected abstract String getBuscarTodosQuery();

	@Override
	public T cadastrar(T entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAvancado");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return entity;
	}

	@Override
	public T buscarPorId(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAvancado");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		T entity = em.find(this.getTipoClasse(), id);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return entity;
	}

	@Override
	public void excluir(T entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAvancado");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.remove(entity);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	@Override
	public T alterar(T entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAvancado");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return entity;
	}

	@Override
	public List<T> buscarTodos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAvancado");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		List<T> entities = em.createQuery(this.getBuscarTodosQuery(), this.getTipoClasse()).getResultList();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return entities;
	}
}





























