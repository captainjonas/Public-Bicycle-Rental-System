package com.aowin.model;

import java.math.BigDecimal;

public class Order {
	private int order_id;
	private String order_code;
	private int vender_id;
	private String buy_date;
	private int buy_num;
	private BigDecimal buy_price;
	private String person_in_charge;
	private String invoice_no;
	private int user_id;
	private String username;
	private String operator_time;
	private String remark;
	private String status;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public int getVender_id() {
		return vender_id;
	}
	public void setVender_id(int vender_id) {
		this.vender_id = vender_id;
	}
	public String getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public BigDecimal getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(BigDecimal buy_price) {
		this.buy_price = buy_price;
	}
	public String getPerson_in_charge() {
		return person_in_charge;
	}
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_code=" + order_code + ", vender_id=" + vender_id + ", buy_date="
				+ buy_date + ", buy_num=" + buy_num + ", buy_price=" + buy_price + ", person_in_charge="
				+ person_in_charge + ", invoice_no=" + invoice_no + ", user_id=" + user_id + ", username=" + username
				+ ", operator_time=" + operator_time + ", remark=" + remark + ", status=" + status + "]";
	}
	public Order(String order_code, int vender_id, String buy_date, int buy_num, BigDecimal buy_price,
			String person_in_charge, String invoice_no, String username, String operator_time, String remark) {
		super();
		this.order_code = order_code;
		this.vender_id = vender_id;
		this.buy_date = buy_date;
		this.buy_num = buy_num;
		this.buy_price = buy_price;
		this.person_in_charge = person_in_charge;
		this.invoice_no = invoice_no;
		this.username = username;
		this.operator_time = operator_time;
		this.remark = remark;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
