package app.dao;

import java.sql.Timestamp;

public class ResultKPL {

    private Long orderDishId;
    private String name;
    private Timestamp date;

    public ResultKPL(Long orderDishId, String name, Timestamp date) {
        this.date = date;
        this.name = name;
        this.orderDishId = orderDishId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getOrderDishId() {
        return orderDishId;
    }
    public void setOrderDishId(Long orderDishId) {
        this.orderDishId = orderDishId;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResultKPL{" +
                "date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}