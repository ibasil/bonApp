package app.dao;

import app.entities.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDao extends Dao<Order, Long> implements IOrderDao {

    public OrderDao() {
        super(Order.class);
    }

    public List<Order> findAllReady() {
        List<Order> listO = null;
        try{
            TypedQuery<Order> query = getEntityManager().createQuery(
                    "SELECT o FROM Order o "
                            + "where not o.status in (app.entities.Order.Status.NOT_READY, app.entities.Order.Status.DELIVERED) "
                            + "order by o.timeTaken asc",
                    Order.class);
            listO = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listO;
    }
}
