package app.services;

import app.entities.Order;
import java.util.List;

public interface IOrderService {

    void create(Order order);
    void update(Order order);
    void setNextStatus(Order order);

    List<Order> findAllReady();

}
