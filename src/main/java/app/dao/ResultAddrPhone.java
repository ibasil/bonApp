package app.dao;

public class ResultAddrPhone {

    private String address;
    private String phone;

    public ResultAddrPhone(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString() {
        return "address=" + address + ",  phone=" + phone;
    }
}
