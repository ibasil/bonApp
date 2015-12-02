package app.dao;

import app.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CustomerDao extends Dao<Customer, Long> implements ICustomerDao {

    public CustomerDao() {
        super(Customer.class);
    }

    public ResultAddrPhone getAddrPhone(Long userId) {
        ResultAddrPhone result = null;

        try {
            TypedQuery<ResultAddrPhone> query = getEntityManager().createQuery(
                    "SELECT new app.dao.ResultAddrPhone(c.address, c.phone) FROM Customer c where c.cid=:id",
                    ResultAddrPhone.class);
            query.setParameter("id", userId);
            result = query.getSingleResult();

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
