package app.dao;

import app.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDao extends Dao<Employee, Long> implements IEmployeeDao {

    public EmployeeDao() {
        super(Employee.class);
    }

    public Employee findUser(String login, String password) {
        Employee user = null;
        try {
            TypedQuery<Employee> query = getEntityManager()
                    .createQuery(
                            "select e from Employee e where e.email=:login and e.password=:pass and e.active = true",
                            Employee.class);
            query.setParameter("login", login);
            query.setParameter("pass", password);
            user = query.getSingleResult();
        } catch (Exception ex) {
            return user;
        }
        return user;
    }

    public List<Employee> findAllActive() {
        List<Employee> listU = null;
        TypedQuery<Employee> query = getEntityManager().createQuery(
                "SELECT e FROM Employee e where e.active = true", Employee.class);
        listU = query.getResultList();
        return listU;
    }
}
