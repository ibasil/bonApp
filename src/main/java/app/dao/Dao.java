package app.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import app.entities.IEntity;


public abstract class Dao<E extends IEntity, ID> implements IDao<E, ID>, Serializable {

    protected Class<E> entityClass;

    private EntityManager entityManager;

    public Dao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(E entity) {
        getEntityManager().persist(entity);
    }

    public void remove(ID id) {
        if (id == null) {
            return;
        }

        E entity = getEntityManager().find(entityClass, id);
        if (entity == null) {
            return;
        }
        getEntityManager().remove(entity);
    }

    public void update(E entity) {
        getEntityManager().merge(entity);
    }

    public E findById(ID id) {
        E entity = null;
        entity = getEntityManager().find(entityClass, id);
        return entity;
    }

    public List<E> findAll() {
        List<E> listE = null;
        TypedQuery<E> query = getEntityManager().createQuery(
                "SELECT e FROM " + entityClass.getName() + " e", entityClass);
        listE = query.getResultList();
        return listE;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
