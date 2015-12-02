package app.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Order implements IEntity{
    public enum Status { NOT_READY, READY_FOR_SHIPMENT, DELIVERING, DELIVERED }
    @Id
    private Integer id;
    @OneToMany(mappedBy="order")
    private List<OrderDish> orderDish;
    private Double OrderSum;
    private java.sql.Timestamp timeTaken;
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_READY;

    public Order() {}

    public Order(Double orderSum, Status status, Timestamp timeTaken) {
        OrderSum = orderSum;
        this.status = status;
        this.timeTaken = timeTaken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderDish> getOrderDish() {
        return orderDish;
    }

    public void setOrderDish(List<OrderDish> orderDish) {
        this.orderDish = orderDish;
    }

    public Double getOrderSum() {
        return OrderSum;
    }

    public void setOrderSum(Double orderSum) {
        OrderSum = orderSum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public java.sql.Timestamp getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(java.sql.Timestamp timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
