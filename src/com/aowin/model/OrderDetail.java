package com.aowin.model;

import java.math.BigDecimal;

public class OrderDetail {
	private int detail_id;
	private int catagory_id;
	private int order_id;
	private String order_code;
	private int bicycle_id;
	private String create_date;
	private String batch_no;
	private BigDecimal price;
	private String remark;
	
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	public int getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(int catagory_id) {
		this.catagory_id = catagory_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(int bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrce(BigDecimal price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderDetail [detail_id=" + detail_id + ", catagory_id=" + catagory_id + ", order_id=" + order_id
				+ ", bicycle_id=" + bicycle_id + ", create_date=" + create_date + ", batch_no=" + batch_no + ", price="
				+ price + ", remark=" + remark + "]";
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int catagory_id, String order_code, String create_date, String batch_no, BigDecimal price,
			String remark) {
		super();
		this.catagory_id = catagory_id;
		this.order_code = order_code;
		this.create_date = create_date;
		this.batch_no = batch_no;
		this.price = price;
		this.remark = remark;
	}
	
	
	

}
