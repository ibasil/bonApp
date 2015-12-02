package app.services;

import app.dao.IEmployeeDao;
import app.entities.Employee;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class EmployeeService implements IEmployeeService, Serializable {

    @Inject
    private IEmployeeDao employeeDao;

    public Employee findUser(String email, String password) {
        Employee e = employeeDao.findUser(email, Crypt.crypt(password));

        if (e != null) {
            e.setPassword(Crypt.crypt(e.getPassword()));
        }
        return e;
    }

    public List<Employee> findAllActive() {
        List<Employee> users = employeeDao.findAllActive();

        if (users != null) {
            for (Employee e : users) {
                e.setPassword(Crypt.crypt(e.getPassword()));
            }
        }
        return users;
    }

    @Transactional
    public void create(Employee user) {
        System.out.println(user.getPassword());

        if (user != null) {
            user.setPassword( Crypt.crypt(user.getPassword()) );
            employeeDao.create(user);
            System.out.println(user.getPassword());
        }
    }

    @Transactional
    public void update(Employee user) {
        if (user != null) {
            user.setPassword( Crypt.crypt(user.getPassword()) );
            employeeDao.update(user);
        }
    }

    public List<Employee> findAll() {
        List<Employee> users = employeeDao.findAll();
        if (users != null) {
            for (Employee e : users) {
                e.setPassword(Crypt.crypt(e.getPassword()));
            }
        }
        return users;
    }
}
