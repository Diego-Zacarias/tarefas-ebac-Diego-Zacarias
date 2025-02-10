package br.com.dlima.dao.generic;

import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public abstract class GenericDAO<T> implements IGenericDAO<T> {

    protected EntityManagerFactory emf;

    protected EntityManager em;

    private final Class<T> persistenteClass;

    public GenericDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    private void openConnection() {
        this.emf = Persistence.createEntityManagerFactory("Projeto4");
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
    }

    private void closeConnection() {
        em.close();
        emf.close();
    }

    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("select obj from ");
        sb.append(this.persistenteClass.getSimpleName());
        sb.append("obj");
        return sb.toString();
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        this.openConnection();
        this.em.persist(entity);
        this.em.getTransaction().commit();
        this.closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.openConnection();
        entity = this.em.merge(entity);
        this.em.refresh(entity);
        this.em.getTransaction().commit();
        this.closeConnection();
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        this.openConnection();
        this.em.merge(entity);
        this.em.getTransaction().commit();
        this.closeConnection();
        return null;
    }

    @Override
    public T consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
        this.openConnection();
        T entity = this.em.find(this.persistenteClass, id);
        this.em.getTransaction().commit();
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        this.openConnection();
        List<T> entities = this.em.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        closeConnection();
        return entities;
    }
}
