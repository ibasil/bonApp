package app.services;

import app.dao.IOrderDishDao;
import app.dao.ReportCategory;
import app.dao.ReportOrder;
import app.dao.ResultKPL;
import app.entities.Order;
import app.entities.OrderDish;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
public class OrderDishService implements IOrderDishService, Serializable {

    @Inject
    private IOrderDishDao orderDishDao;

    public List<ResultKPL> getKitchenPendingList() {
        return orderDishDao.getKitchenPendingList();
    }

    public Order getOrderIfReady(Long orderId) {
        return orderDishDao.getOrderIfReady(orderId);
    }

    public Long getOrderId(Long orderDishId) {
        return orderDishDao.getOrderId(orderDishId);
    }

    public List<ReportOrder> getReportOrders(Date begin, Date end) {
        return orderDishDao.getReportOrders(begin, end);
    }

    public List<ReportCategory> getReportCategories(Date begin, Date end) {
        return orderDishDao.getReportCategories(begin, end);
    }

    @Transactional
    public void update(OrderDish orderDish) {
        orderDishDao.update(orderDish);
    }

    @Transactional(readOnly=true)
    public OrderDish findById(Long id) {
        return orderDishDao.findById(id);
    }

    @Transactional
    public void create(OrderDish orderDish) {
        orderDishDao.create(orderDish);
    }
}