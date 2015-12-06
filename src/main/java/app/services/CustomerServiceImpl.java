package app.services;

import app.dao.ICustomerDao;
import app.dao.ResultAddrPhone;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class CustomerServiceImpl implements ICustomerService, Serializable {

    @Inject
    private ICustomerDao customerDao;

    public ResultAddrPhone getAddrPhone(Long userId) {
        return customerDao.getAddrPhone(userId);
    }
}
