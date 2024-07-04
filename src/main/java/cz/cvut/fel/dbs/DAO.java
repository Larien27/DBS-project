package cz.cvut.fel.dbs;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class DAO<T> {
    private Class<T> classs;
    EntityManager entityManager;

    public DAO() {
    }

    public DAO(Class<T> classs) {
        this.classs = classs;
    }

    public void create() {
        entityManager.persist((T)this);
    }

    public T readOne(Object id) {
       return entityManager.find(classs, id);
    }

    public List readAll(String table) {
        return entityManager.createQuery("from " + table).getResultList();
    }

    public T update() {
        return entityManager.merge((T)this);
    }

    public void delete() {
        entityManager.remove((T)this);
    }

    public T bind(EntityManager entityManager){
        this.entityManager = entityManager;
        return (T) this;
    }
}
