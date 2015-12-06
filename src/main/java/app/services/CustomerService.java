package app.services;

import app.dao.ResultAddrPhone;
import app.entities.Customer;

public interface CustomerService {
    ResultAddrPhone getAddrPhone(Long userId);

    void create(Customer customer);
}
