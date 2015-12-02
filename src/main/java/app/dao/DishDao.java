package app.dao;

import app.entities.Dish;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DishDao extends Dao<Dish, Long> implements IDishDao {

    public DishDao() {
        super(Dish.class);
    }

    public List<Dish> findAllActive(Long categoryID) {
        List<Dish> listd = null;
        try{
            TypedQuery<Dish> query = getEntityManager().createQuery("SELECT d FROM Dish d where d.category.catid=:id and d.active = true", Dish.class);
            query.setParameter("id", categoryID);
            listd = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listd;
    }

    public List<ResultDS> getDishStatusList(Long orderId) {
        List<ResultDS> result = null;
        try {
            TypedQuery<ResultDS> query = getEntityManager().createQuery(
                    "select new app.dao.ResultDS(od.dish.title, od.dish.kitchenMade)"
                            + " from OrderDish od where od.order.id=:id" ,ResultDS.class);
            query.setParameter("id", orderId);
            result = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Dish> findAllActive() {
        List<Dish> listD = null;
        try{
            TypedQuery<Dish> query = getEntityManager().createQuery("SELECT d FROM Dish d where d.active = true", Dish.class);
            listD = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listD;
    }
}
