package app.services;

import app.dao.ResultAddrPhone;

public interface CustomerService {
    ResultAddrPhone getAddrPhone(Long userId);
}
