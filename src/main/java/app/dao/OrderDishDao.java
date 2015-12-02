package app.dao;

import app.entities.Order;
import app.entities.OrderDish;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDishDao extends Dao<OrderDish, Long> implements IOrderDishDao, Serializable {

    public OrderDishDao() {
        super(OrderDish.class);
    }

    public List<ResultKPL> getKitchenPendingList() {
        List<ResultKPL> result = null;
        try {
            result = getEntityManager().createQuery(
                    "SELECT new app.dao.ResultKPL(od.odid, od.dish.title, od.order.timeTaken) "
                            + "FROM OrderDish od "
                            + "where od.done = false and od.dish.kitchenMade = true "
                            + "order by od.order.timeTaken asc", ResultKPL.class)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Order getOrderIfReady(Long orderId) {
        List<Order> order = null;
        try {
            TypedQuery<Order> query = getEntityManager().createQuery(
                    "select od.order from OrderDish od "
                            + "where od.order.id=:id "
                            + "having sum(od.done) = count(od.done)",
                    Order.class);
            query.setParameter("id", orderId);
            order = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (order.isEmpty()) {
            return null;
        } else {
            return order.get(0);
        }
    }

    public Long getOrderId(Long orderDishId) {
        List<Long> order = null;
        try {
            TypedQuery<Long> query = getEntityManager().createQuery(
                    "select od.order.id from OrderDish od where od.odid=:id", Long.class);
            query.setParameter("id", orderDishId);
            order = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (order.isEmpty()) {
            return null;
        } else {
            return order.get(0);
        }
    }

    public List<ReportOrder> getReportOrders(Date begin, Date end) {
        List<ReportOrder> result = Collections.emptyList();
        try {
            TypedQuery<ReportOrder> query = getEntityManager()
                    .createQuery(
                            "select new app.dao.ReportOrder(func('DATE',od.order.timeTaken), count(DISTINCT od.order.id), sum(od.priceSold)) "
                                    + "from OrderDish od "
                                    + "where func('DATE', od.order.timeTaken) BETWEEN :begin AND :end "
                                    + "group by func('DATE',od.order.timeTaken)",
                            ReportOrder.class);
            query.setParameter("begin", begin);
            query.setParameter("end", end);
            result = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<ReportCategory> getReportCategories(Date begin, Date end) {
        List<ReportCategory> result = Collections.emptyList();;
        try {
            TypedQuery<ReportCategory> query = getEntityManager()
                    .createQuery(
                            "select new app.dao.ReportCategory(od.dish.category.title, count(od.priceSold), sum(od.priceSold)) "
                                    + "from OrderDish od "
                                    + "where func('DATE', od.order.timeTaken) BETWEEN :begin AND :end "
                                    + "group by od.dish.category.title",
                            ReportCategory.class);
            query.setParameter("begin", begin);
            query.setParameter("end", end);
            result = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}