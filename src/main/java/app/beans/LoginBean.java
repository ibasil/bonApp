package app.beans;

import app.entities.Customer;
import app.entities.Employee;
import app.services.CustomerService;
import app.services.EmployeeService;
import org.springframework.context.annotation.Scope;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named
@Scope("session")
public class LoginBean implements Serializable {

    private static final long serialVersionUID = -6557299908148699208L;

    private String email;
    private String password;

    private Employee employee = new Employee();

    @Inject
    private EmployeeService employeeService;

    public LoginBean() {
    }

    public String auth(String login, String password) {
        employee = employeeService.login(login, password);


        if (employee != null && employee.isActive() == true) {

            switch (employee.getRole()) {
                case "admin":
                    return "admin";
                case "analyst":
                    return "analyst";
                case "cook":
                    return "kitchenPendingList";
                case "root":
                    return "su";
                default: return "login";
            }
        }
            else{
                return "login";
            }
        }

    public String Logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "auth";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

