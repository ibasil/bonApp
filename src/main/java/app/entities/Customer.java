package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements IEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cid;
    private String fullName;
    private String address;
    private String phone;

    public Customer() {}

    Customer (String fullName, String address, String phone) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
