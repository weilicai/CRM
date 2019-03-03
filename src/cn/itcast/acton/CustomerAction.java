package cn.itcast.acton;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public String listPage() {
		System.out.println();
		PageBean pageBean = customerService.listPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	public String toAddPage() {
		return "toAddPage";
	}
	
	public String add() {
		customerService.add(customer);
		return "add";
	}
	
	public String list() {
		List<Customer> list = customerService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return "list";
	}

	public String delete() {
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		if(c != null) {
			customerService.delete(c);
		}
		return "delete";
	}
	
	public String showCustomer() {
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer",c);
		return "showCustomer";
	}
	
	public String update() {
		customerService.update(customer);
		return "update";
	}
	
	public String listcondition() {
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
			List<Customer> list = customerService.findCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else {
			list();
		}
		return "listcondition";
	}
}
