package app.beans;

import app.entities.Customer;
import app.entities.Dish;
import app.entities.Order;
import app.entities.OrderDish;
import app.services.DishService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@Scope("session")
public class CartBean implements Serializable{

    private Order order = null;
    private Dish dish = null;
    private OrderDish od = null;

    private List<Dish> menu = null;
    private List<OrderDish> listOrdered = null;

    private Customer currentCustomer = null;
    private double sum = 0; //Total sum of the cart

    @Inject
    DishService dishService;
    @Inject
    CustomerBean customerBean;


    @PostConstruct
    public void init() {
        order = new Order();
        listOrdered = new ArrayList<OrderDish>();

    }

    public void saveCart(Dish d) {

        dish = dishService.findById(Long.valueOf(d.getDid()));
        sum += dish.getPrice();

        OrderDish od = new OrderDish();
        od.setPriceSold(dish.getPrice());
        od.setDish(d);
        od.setOrder(order);

        listOrdered.add(od);

    }

    public void remove(OrderDish dish) {
        sum -= dish.getPriceSold();
        listOrdered.remove(dish);
    }

    public String checkout(){
        System.out.println("Content of listOrdered:");
        System.out.println(Arrays.asList(listOrdered));

        order.setStatus(Order.Status.READY_FOR_SHIPMENT);
        order.setTimeTaken(new java.sql.Timestamp(new Date().getTime()));

        order.setOrderSum(sum);
        currentCustomer = customerBean.getCustomer();

        order.setId(currentCustomer.getCid());

        System.out.println(Arrays.asList(order));

        order.setOrderDish(listOrdered);
        dishService.create(order);
        clear();
        return "ordered";
    }

    public String  calcTotal(){
        return String.format("%.2f", sum);

    }

    public String calcItems(){
        return String.valueOf(listOrdered.size());
    }
    public String show() {
        return "cartList";
    }
    public void refresh(){
        menu = dishService.getAllActive();
    }

    public void clear(){
        currentCustomer.setFullName("");
        currentCustomer.setAddress("");
        currentCustomer.setPhone("");
        customerBean.setCustomer(currentCustomer);

        if(!listOrdered.isEmpty()) {
            listOrdered.clear();
            sum = 0;
        }

    }

    public DishService getDishService() {
        return dishService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public List<OrderDish> getListOrdered() {
        return listOrdered;
    }

    public void setListOrdered(List<OrderDish> listOrdered) {
        this.listOrdered = listOrdered;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public OrderDish getOd() {
        return od;
    }

    public void setOd(OrderDish od) {
        this.od = od;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}
