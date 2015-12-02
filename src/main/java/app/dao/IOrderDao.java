package app.dao;

import app.entities.Order;
import java.util.List;

public interface IOrderDao extends IDao<Order, Long> {

    List<Order> findAllReady();

}