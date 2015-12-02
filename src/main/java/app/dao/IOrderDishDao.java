package app.dao;

import app.entities.Order;
import app.entities.OrderDish;

import java.util.Date;
import java.util.List;

public interface IOrderDishDao extends IDao<OrderDish, Long> {

    List<ResultKPL> getKitchenPendingList();
    Order getOrderIfReady(Long orderDishId);
    Long getOrderId(Long id);
    List<ReportOrder> getReportOrders(Date begin, Date end);
    List<ReportCategory> getReportCategories(Date begin, Date end);
}
