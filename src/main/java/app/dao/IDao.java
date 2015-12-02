package app.dao;

import java.util.List;
import app.entities.IEntity;

public interface IDao<E extends IEntity, ID> {

    void create(E entity);
    void remove(ID id);
    void update(E entity);
    E findById(ID id);

    List<E> findAll();
}
