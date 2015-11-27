package app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category implements IEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer catid;
    private String title;
    private String status;

    @OneToMany(mappedBy="category", fetch=FetchType.EAGER)
    private List<Dish> dishes;

    public Category() {}

    Category(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
