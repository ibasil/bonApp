package app.services;

import app.entities.Order;
import java.util.List;

public interface OrderService {

    void create(Order order);
    void update(Order order);
    void setNextStatus(Order order);

    List<Order> findAllReady();

}
