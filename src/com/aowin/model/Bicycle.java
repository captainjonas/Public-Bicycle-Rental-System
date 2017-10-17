package com.aowin.model;

public class Bicycle {
	private int bicycle_id;
	private String bicycle_code;
	private String status;
	private int pile_id;
	private String destroy_date;
	private int user_id;
	private String operator_time;
	private int card_id;
	private String remark;
	private String repair_date;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRepair_date() {
		return repair_date;
	}
	public void setRepair_date(String repair_date) {
		this.repair_date = repair_date;
	}
	public int getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(int bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getBicycle_code() {
		return bicycle_code;
	}
	public void setBicycle_code(String bicycle_code) {
		this.bicycle_code = bicycle_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPile_id() {
		return pile_id;
	}
	public void setPile_id(int pile_id) {
		this.pile_id = pile_id;
	}
	public String getDestroy_date() {
		return destroy_date;
	}
	public void setDestroy_date(String destroy_date) {
		this.destroy_date = destroy_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Bicycle [bicycle_id=" + bicycle_id + ", bicycle_code=" + bicycle_code + ", status=" + status
				+ ", pile_id=" + pile_id + ", destroy_date=" + destroy_date + ", user_id=" + user_id
				+ ", operator_time=" + operator_time + ", card_id=" + card_id + ", remark=" + remark + "]";
	}
	public Bicycle(int bicycle_id, String bicycle_code, String repair_date) {
		super();
		this.bicycle_id = bicycle_id;
		this.bicycle_code = bicycle_code;
		this.repair_date = repair_date;
	}
	
	
	public Bicycle(String operator_time, String username) {
		super();
		this.operator_time = operator_time;
		this.username = username;
	}
	public Bicycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
