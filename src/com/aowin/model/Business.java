package com.aowin.model;

import java.math.BigDecimal;

public class Business {
	private int business_id;
	private String create_time;
	private String business_name;
	private String business_type;
	private int related_record_id;
	private int card_id;
	private String charged;
	private BigDecimal fee;
	private String charge_type;
	private int bicycle_id;
	private int pile_id;
	private int operator;
	private String username;
	private String order_code;
	
	
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}
	public int getRelated_record_id() {
		return related_record_id;
	}
	public void setRelated_record_id(int related_record_id) {
		this.related_record_id = related_record_id;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getCharged() {
		return charged;
	}
	public void setCharged(String charged) {
		this.charged = charged;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public int getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(int bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public int getPile_id() {
		return pile_id;
	}
	public void setPile_id(int pile_id) {
		this.pile_id = pile_id;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return "Business [business_id=" + business_id + ", create_time=" + create_time + ", business_name="
				+ business_name + ", business_type=" + business_type + ", related_record_id=" + related_record_id
				+ ", card_id=" + card_id + ", charged=" + charged + ", fee=" + fee + ", charge_type=" + charge_type
				+ ", bicycle_id=" + bicycle_id + ", pile_id=" + pile_id + ", operator=" + operator + "]";
	}
	
	
	public Business(String create_time, BigDecimal fee, String username, String order_code) {
		super();
		this.create_time = create_time;
		this.fee = fee;
		this.username = username;
		this.order_code = order_code;
	}
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Business(String create_time, int bicycle_id, String username) {
		super();
		this.create_time = create_time;
		this.bicycle_id = bicycle_id;
		this.username = username;
	}
	public Business(String create_time, int bicycle_id, int pile_id, String username) {
		super();
		this.create_time = create_time;
		this.bicycle_id = bicycle_id;
		this.pile_id = pile_id;
		this.username = username;
	}
		
}
