package app.dao;

import app.entities.Employee;
import java.util.List;

public interface IEmployeeDao extends IDao<Employee, Long>{

    Employee findUser(String login, String password);
    List<Employee> findAllActive();

}
