package cn.itcast.entity;

public class LinkMan {
	private Integer linkId;
	private String lkmName;
	private String lkmGender;
	private String lkmPhone;
	private String lkmMoblie;
	
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public String getLkmGender() {
		return lkmGender;
	}
	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}
	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}
	public String getLkmMoblie() {
		return lkmMoblie;
	}
	public void setLkmMoblie(String lkmMoblie) {
		this.lkmMoblie = lkmMoblie;
	}
}
