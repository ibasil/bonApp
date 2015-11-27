package app.entities;

import javax.persistence.*;

@Entity
public class OrderDish {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer odid;
    @ManyToOne
    @JoinColumn(name="id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="did")
    private Dish dish;

    private Double priceSold;
    private String status;

    public OrderDish() {}

    public OrderDish(Dish dish, Order order, Double priceSold) {
        this.dish = dish;
        this.order = order;
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
