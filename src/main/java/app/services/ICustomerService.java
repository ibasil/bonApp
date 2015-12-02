package app.services;

import app.dao.ResultAddrPhone;

public interface ICustomerService {
    ResultAddrPhone getAddrPhone(Long userId);
}
