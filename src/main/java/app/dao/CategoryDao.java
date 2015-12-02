package app.dao;

import app.entities.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryDao extends Dao<Category, Long> implements ICategoryDao {

    public CategoryDao() {
        super(Category.class);
    }

    public List<Category> findAllActive() {
        List<Category> listC = null;
        try{
            TypedQuery<Category> query = getEntityManager().createQuery("SELECT c FROM Category c where c.active = true", Category.class);
            listC = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listC;
    }

    public Category findByName(String name) {
        List<Category> listC = null;
        try{
            TypedQuery<Category> query = getEntityManager().createQuery("SELECT c FROM Category c where c.title = :name", Category.class);
            query.setParameter("name", name);
            listC = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listC.get(0);
    }
}