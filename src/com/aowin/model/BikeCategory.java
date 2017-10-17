package com.aowin.model;

public class BikeCategory {
	private int catagory_id;
	private String catagory_name;
	private String frame_type;
	private String tire_type;
	private double weight;
	private double height;
	private double length;
	private String ring_type;
	private String basket;
	private String backseat;
	private String bicycle_seat;
	private String handBrake;
	private String remark;
	private int user_id;
	private String operator_time;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(int catagory_id) {
		this.catagory_id = catagory_id;
	}
	public String getCatagory_name() {
		return catagory_name;
	}
	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}
	public String getFrame_type() {
		return frame_type;
	}
	public void setFrame_type(String frame_type) {
		this.frame_type = frame_type;
	}
	public String getTire_type() {
		return tire_type;
	}
	public void setTire_type(String tire_type) {
		this.tire_type = tire_type;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public String getRing_type() {
		return ring_type;
	}
	public void setRing_type(String ring_type) {
		this.ring_type = ring_type;
	}
	public String getBasket() {
		return basket;
	}
	public void setBasket(String basket) {
		this.basket = basket;
	}
	public String getBackseat() {
		return backseat;
	}
	public void setBackseat(String backseat) {
		this.backseat = backseat;
	}
	public String getBicycle_seat() {
		return bicycle_seat;
	}
	public void setBicycle_seat(String bicycle_seat) {
		this.bicycle_seat = bicycle_seat;
	}
	public String getHandBrake() {
		return handBrake;
	}
	public void setHandBrake(String handBrake) {
		this.handBrake = handBrake;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@Override
	public String toString() {
		return "BikeCategory [catagory_id=" + catagory_id + ", catagory_name=" + catagory_name + ", frame_type="
				+ frame_type + ", tire_type=" + tire_type + ", weight=" + weight + ", height=" + height + ", length="
				+ length + ", ring_type=" + ring_type + ", basket=" + basket + ", backseat=" + backseat
				+ ", bicycle_seat=" + bicycle_seat + ", handBrake=" + handBrake + ", remark=" + remark + ", user_id="
				+ user_id + ",username="+username+", operator_time=" + operator_time + "]";
	}
	public BikeCategory() {
		super();
	}
	public BikeCategory(int catagory_id, String catagory_name, String tire_type, String ring_type, String backseat,
			String bicycle_seat, String username, String operator_time) {
		super();
		this.catagory_id = catagory_id;
		this.catagory_name = catagory_name;
		this.tire_type = tire_type;
		this.ring_type = ring_type;
		this.backseat = backseat;
		this.bicycle_seat = bicycle_seat;
		this.username = username;
		this.operator_time = operator_time;
	}
	public BikeCategory(String catagory_name, String frame_type, String tire_type, double weight, double height,
			double length, String ring_type, String basket, String backseat, String bicycle_seat, String handBrake,
			String remark, String username, String operator_time) {
		super();
		this.catagory_name = catagory_name;
		this.frame_type = frame_type;
		this.tire_type = tire_type;
		this.weight = weight;
		this.height = height;
		this.length = length;
		this.ring_type = ring_type;
		this.basket = basket;
		this.backseat = backseat;
		this.bicycle_seat = bicycle_seat;
		this.handBrake = handBrake;
		this.remark = remark;
		this.username = username;
		this.operator_time = operator_time;
	}
	
	
	
	

}
