package app.beans;

import app.dao.ReportCategory;
import app.dao.ReportOrder;
import app.entities.Employee;
import app.services.EmployeeService;
import app.services.OrderDishService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Named
@Scope("session")
public class AnalystBean implements Serializable {

    private Employee employee;
    private Date start;
    private Date end;

    @Inject
    EmployeeService employeeService;

    @Inject
    private OrderDishService orderDishService;

    private List report = new ArrayList<ReportOrder>();
    private List reportCategory = new ArrayList<ReportCategory>();

    public String redirect() {
        refresh();
        return "report";
    }

    public String redirectCategory() {
        refreshCategory();
        return "reportCategory";
    }

    public void refresh() {
        System.out.println(Arrays.asList(report));
        report = orderDishService.getReportOrders(start, end);
        reportCategory = orderDishService.getReportCategories(start, end);
    }

    public void refreshCategory() {
        reportCategory = orderDishService.getReportCategories(start, end);
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


    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public List getReport() {
        return report;
    }

    public void setReport(List report) {
        this.report = report;
    }

    public List getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(List reportCategory) {
        this.reportCategory = reportCategory;
    }

    public OrderDishService getOrderDishService() {
        return orderDishService;
    }

    public void setOrderDishService(OrderDishService orderDishService) {
        this.orderDishService = orderDishService;
    }

        }
