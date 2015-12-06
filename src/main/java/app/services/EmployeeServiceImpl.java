package app.services;

import app.dao.IEmployeeDao;
import app.entities.Employee;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class EmployeeServiceImpl implements EmployeeService, Serializable {

    @Inject
    private IEmployeeDao employeeDao;

    public Employee findUser(String email, String password) {
        Employee e = employeeDao.login(email, Crypt.crypt(password));

        if (e != null) {
            e.setPassword(Crypt.crypt(e.getPassword()));
        }
        return e;
    }

    public List<Employee> getAllActive() {
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

    @Override
    public void disable(Employee e) {
        e.setActive(false);
    }

    public List<Employee> getAll() {
        List<Employee> users = employeeDao.findAll();
        if (users != null) {
            for (Employee e : users) {
                e.setPassword(Crypt.crypt(e.getPassword()));
            }
        }
        return users;
    }

    @Override
    public Employee login(String login, String password) {
        return employeeDao.login(login, password);
    }
}
