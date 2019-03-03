package cn.itcast.acton;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	private static final long serialVersionUID = 1L;
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private File upload;
	private String uploadFileName;
	
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String toAddPage() {
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	
	public String addLinkMan() throws Exception {
/*		if(upload != null) {
			File serverFile = new File("F://sshjmg"+"/"+uploadFileName);
			FileUtils.copyFile(upload, serverFile);
		}*/
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}
	
	public String list() {
		List<LinkMan> list = linkManService.listLinkMan();
		System.out.println(list);
		ServletActionContext.getRequest().setAttribute("list",list);
		return "list";
	}
	
	public String showLinkMan() {
		int linkId = linkMan.getLinkId();
		LinkMan link = linkManService.findOne(linkId);
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("linkman", link);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	public String updateLinkMan() {
		linkManService.updateLink(linkMan);
		return "updateLinkMan";
	}
}
