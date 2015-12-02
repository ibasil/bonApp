package app.dao;

import app.entities.Customer;

public interface ICustomerDao extends IDao<Customer, Long> {

    ResultAddrPhone getAddrPhone(Long userId);

}
