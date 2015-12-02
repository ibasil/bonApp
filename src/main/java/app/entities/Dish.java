package app.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Dish implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    @ManyToOne
    @JoinColumn(name="catid")
    private Category category;
    private String title;
    private boolean kitchenMade;
    private Double price;
    private java.sql.Timestamp dateAdded;
    private String description;
    private boolean active = true;

    public Dish() {}

    public Dish(boolean active, Category category, Timestamp dateAdded, String description, boolean kitchenMade, Double price, String title) {
        this.active = active;
        this.category = category;
        this.dateAdded = dateAdded;
        this.description = description;
        this.kitchenMade = kitchenMade;
        this.price = price;
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public boolean isKitchenMade() {
        return kitchenMade;
    }

    public void setKitchenMade(boolean kitchenMade) {
        this.kitchenMade = kitchenMade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "title='" + title + '\'' +
                '}';
    }
}
