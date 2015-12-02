package app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category implements IEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer catid;
    private String title;
    private boolean active = true;

    @OneToMany(mappedBy="category", fetch=FetchType.EAGER)
    private List<Dish> dishes;

    public Category() {}

    Category(String title, boolean active) {
        this.title = title;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
