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
    private String made;
    private Double price;
    private java.sql.Timestamp dateAdded;
    private String description;
    private String status;

    public Dish() {}

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

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
