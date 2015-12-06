package app.beans;

import app.entities.Employee;
import app.services.EmployeeService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Scope("session")
public class SuBean implements Serializable {

	private static final long serialVersionUID = 4315731896522490406L;

	private Employee employee;
	private List<Employee> staff = new ArrayList<>();

	@Inject
	EmployeeService employeeService;

	@PostConstruct
	public void init() {
		refresh();
	}

	SuBean(){
		employee  = new Employee();
	}

	public String save() {
		employeeService.create(employee);
		return "suList";
	}

	public String update(Employee employee) {
		System.out.println(employee);
		employeeService.update(employee);
		return "suAdd";
	}
	
	public String disable(Employee e) {
		employeeService.disable(e);
		return "suList";
	}

	public void refresh() {
		staff = employeeService.getAll();
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

	public List<Employee> getStaff() {
		return staff;
	}

	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}
}
