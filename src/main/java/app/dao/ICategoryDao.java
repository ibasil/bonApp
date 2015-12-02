package app.dao;

import app.entities.Category;
import java.util.List;

public interface ICategoryDao extends IDao<Category, Long> {

    List<Category> findAllActive();
    Category findByName(String name);

}
