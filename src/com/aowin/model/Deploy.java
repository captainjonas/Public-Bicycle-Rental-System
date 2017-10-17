package com.aowin.model;

public class Deploy {
	private int deploy_id;
	private int bicycle_id;
	private int from_pile_id;
	private int to_pile_id;
	private int from_card_id;
	private String from_time;
	private int to_card_id;
	private String to_time;
	private String to_reason;
	private String from_reason;
	private String remark;
	private String status;
	public int getDeploy_id() {
		return deploy_id;
	}
	public void setDeploy_id(int deploy_id) {
		this.deploy_id = deploy_id;
	}
	public int getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(int bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public int getFrom_pile_id() {
		return from_pile_id;
	}
	public void setFrom_pile_id(int from_pile_id) {
		this.from_pile_id = from_pile_id;
	}
	public int getTo_pile_id() {
		return to_pile_id;
	}
	public void setTo_pile_id(int to_pile_id) {
		this.to_pile_id = to_pile_id;
	}
	public int getFrom_card_id() {
		return from_card_id;
	}
	public void setFrom_card_id(int from_card_id) {
		this.from_card_id = from_card_id;
	}
	public String getFrom_time() {
		return from_time;
	}
	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}
	public int getTo_card_id() {
		return to_card_id;
	}
	public void setTo_card_id(int to_card_id) {
		this.to_card_id = to_card_id;
	}
	public String getTo_time() {
		return to_time;
	}
	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}
	public String getTo_reason() {
		return to_reason;
	}
	public void setTo_reason(String to_reason) {
		this.to_reason = to_reason;
	}
	public String getFrom_reason() {
		return from_reason;
	}
	public void setFrom_reason(String from_reason) {
		this.from_reason = from_reason;
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
		return "Deploy [deploy_id=" + deploy_id + ", bicycle_id=" + bicycle_id + ", from_pile_id=" + from_pile_id
				+ ", to_pile_id=" + to_pile_id + ", from_card_id=" + from_card_id + ", from_time=" + from_time
				+ ", to_card_id=" + to_card_id + ", to_time=" + to_time + ", to_reason=" + to_reason + ", from_reason="
				+ from_reason + ", remark=" + remark + ", status=" + status + "]";
	}
	public Deploy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deploy(int bicycle_id, int to_pile_id, String to_time) {
		super();
		this.bicycle_id = bicycle_id;
		this.to_pile_id = to_pile_id;
		this.to_time = to_time;
	}
	
	

}
