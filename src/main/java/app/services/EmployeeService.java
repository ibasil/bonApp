package app.services;

import app.entities.Employee;
import java.util.List;

public interface EmployeeService {

    void create(Employee e);
    void update(Employee e);
    void disable(Employee e);

    Employee findUser(String email, String password);
    List<Employee> getAllActive();
    List<Employee> getAll();


    Employee login(String login, String password);
}
