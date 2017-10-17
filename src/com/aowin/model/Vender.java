package com.aowin.model;

public class Vender {
	private int vender_id;
	private String vender_code;
	private String vender_type;
	private String vender_name;
	private String address;
	private String telphone;
	private String contacts;
	private String product_license;
	private String business_registration_no;
	private double registered_capital;
	private int user_id;
	private String create_time;
	private String ZXBJ;
	private String remark;
	public int getVender_id() {
		return vender_id;
	}
	public void setVender_id(int vender_id) {
		this.vender_id = vender_id;
	}
	public String getVender_code() {
		return vender_code;
	}
	public void setVender_code(String vender_code) {
		this.vender_code = vender_code;
	}
	public String getVender_type() {
		return vender_type;
	}
	public void setVender_type(String vender_type) {
		this.vender_type = vender_type;
	}
	public String getVender_name() {
		return vender_name;
	}
	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getProduct_license() {
		return product_license;
	}
	public void setProduct_license(String product_license) {
		this.product_license = product_license;
	}
	public String getBusiness_registration_no() {
		return business_registration_no;
	}
	public void setBusiness_registration_no(String business_registration_no) {
		this.business_registration_no = business_registration_no;
	}
	public double getRegistered_capital() {
		return registered_capital;
	}
	public void setRegistered_capital(double registered_capital) {
		this.registered_capital = registered_capital;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getZXBJ() {
		return ZXBJ;
	}
	public void setZXBJ(String zXBJ) {
		ZXBJ = zXBJ;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Vender(int vender_id, String vender_name) {
		super();
		this.vender_id = vender_id;
		this.vender_name = vender_name;
	}
	public Vender() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
