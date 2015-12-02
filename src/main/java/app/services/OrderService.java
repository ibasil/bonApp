package app.services;

import app.dao.IOrderDao;
import app.entities.Order;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class OrderService implements IOrderService, Serializable {

    @Inject
    private IOrderDao orderDao;

    public List<Order> findAllReady() {
        return orderDao.findAllReady();
    }

    @Transactional
    public void update(Order order) {
        orderDao.update(order);
    }

    @Transactional
    public void create(Order order) {
        orderDao.create(order);
    }

    public void setNextStatus(Order order) {
        if (order.getStatus() != Order.Status.DELIVERED)
            order.setStatus(Order.Status.values()[order.getStatus().ordinal() + 1]);
    }
}
