package app.services;

import app.dao.ResultKPL;
import app.dao.ReportCategory;
import app.dao.ReportOrder;
import app.entities.Order;
import app.entities.OrderDish;

import java.util.Date;
import java.util.List;

public interface IOrderDishService {


    Order getOrderIfReady(Long orderDishId);
    Long getOrderId(Long id);
    List<ResultKPL> getKitchenPendingList();

    List<ReportOrder> getReportOrders(Date begin, Date end);
    List<ReportCategory> getReportCategories(Date begin, Date end);

    void create(OrderDish orderDish);
    void update(OrderDish orderDish);
    OrderDish findById(Long id);

}
