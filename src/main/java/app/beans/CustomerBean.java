package app.beans;

import app.entities.Customer;
import app.services.CustomerService;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Scope("session")
public class CustomerBean implements Serializable{

	private Customer customer = new Customer();
	@Inject
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String save() {
		customerService.create(customer);
		return "cartAdd";
	}

	public String show() {
		return "cartList";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
