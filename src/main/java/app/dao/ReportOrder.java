package app.dao;

import java.util.Date;

public class ReportOrder {

    private Date date;
    private Long orderNumber;
    private double totalSum;

    public ReportOrder() {

    }

    public ReportOrder(Date date, Long orderNumber, double totalSum) {
        this.date = date;
        this.orderNumber = orderNumber;
        this.totalSum = totalSum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "ReportOrder{" +
                "date=" + date +
                ", orderNumber=" + orderNumber +
                ", totalSum=" + totalSum +
                '}';
    }
}