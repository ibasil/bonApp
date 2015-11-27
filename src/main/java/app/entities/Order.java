package app.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Order implements IEntity{
    public enum Status { NOT_READY, READY_FOR_SHIPMENT, DELIVERING, DELIVERED }
    @Id
    private Integer id;
    private Double OrderSum;
    private Date timeTaken;
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_READY;

    public Order() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
