package app.entities;

import javax.persistence.*;

@Entity
public class OrderDish implements IEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long odid;
    @ManyToOne
    @JoinColumn(name="id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="did")
    private Dish dish;

    private Double priceSold;
    private boolean done;

    public OrderDish() {}

    public OrderDish(Dish dish, Order order, Double priceSold) {
        this.dish = dish;
        this.order = order;
        this.priceSold = priceSold;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getOdid() {
        return odid;
    }

    public void setOdid(Long odid) {
        this.odid = odid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(Double priceSold) {
        this.priceSold = priceSold;
    }

    @Override
    public String toString() {
        return "OrderDish{" +
                "odid=" + odid +
                ", dish id=" + dish.getDid() +
                '}';
    }
}
