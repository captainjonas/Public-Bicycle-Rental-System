package com.aowin.model;

public class Station {
	private int station_id;
	private String station_code;
	private String station_name;
	private double longitude;
	private double latitude;
	private int bicycle_pile_num;
	private String address;
	private String person_in_charge;
	private String build_time;
	private String run_time;
	private int user_id;
	private String create_time;
	private String remark;
	private int ZXBJ;
	private String username;
	private int pile_id;
	private int vender_id;
	private String pile_code;
	private String install_time;
	private String disassembly_time;
	private String operator_time;
	private String bicycle_id;
	private String status;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getZXBJ() {
		return ZXBJ;
	}
	public void setZXBJ(int zXBJ) {
		ZXBJ = zXBJ;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getBicycle_pile_num() {
		return bicycle_pile_num;
	}
	public void setBicycle_pile_num(int bicycle_pile_num) {
		this.bicycle_pile_num = bicycle_pile_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPerson_in_charge() {
		return person_in_charge;
	}
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}
	public String getBuild_time() {
		return build_time;
	}
	public void setBuild_time(String build_time) {
		this.build_time = build_time;
	}
	public String getRun_time() {
		return run_time;
	}
	public void setRun_time(String run_time) {
		this.run_time = run_time;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getPile_id() {
		return pile_id;
	}
	public void setPile_id(int pile_id) {
		this.pile_id = pile_id;
	}
	public int getVender_id() {
		return vender_id;
	}
	public void setVender_id(int vender_id) {
		this.vender_id = vender_id;
	}
	public String getPile_code() {
		return pile_code;
	}
	public void setPile_code(String pile_code) {
		this.pile_code = pile_code;
	}
	public String getInstall_time() {
		return install_time;
	}
	public void setInstall_time(String install_time) {
		this.install_time = install_time;
	}
	public String getDisassembly_time() {
		return disassembly_time;
	}
	public void setDisassembly_time(String disassembly_time) {
		this.disassembly_time = disassembly_time;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	public String getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(String bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Station [station_id=" + station_id + ", station_code=" + station_code + ", station_name=" + station_name
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", bicycle_pile_num=" + bicycle_pile_num
				+ ", address=" + address + ", person_in_charge=" + person_in_charge + ", build_time=" + build_time
				+ ", run_time=" + run_time + ", user_id=" + user_id + ", create_time=" + create_time + ", remark="
				+ remark + "]";
	}
	public Station(String station_code, String station_name, double longitude, double latitude, int bicycle_pile_num,
			String address, String person_in_charge, String build_time, String run_time, String create_time,
			String remark, String username) {
		super();
		this.station_code = station_code;
		this.station_name = station_name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.bicycle_pile_num = bicycle_pile_num;
		this.address = address;
		this.person_in_charge = person_in_charge;
		this.build_time = build_time;
		this.run_time = run_time;
		this.create_time = create_time;
		this.remark = remark;
		this.username = username;
	}
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station(int station_id, String station_code, String station_name, double longitude, double latitude,
			int bicycle_pile_num, String address, String person_in_charge, String run_time, String remark) {
		super();
		this.station_id = station_id;
		this.station_code = station_code;
		this.station_name = station_name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.bicycle_pile_num = bicycle_pile_num;
		this.address = address;
		this.person_in_charge = person_in_charge;
		this.run_time = run_time;
		this.remark = remark;
	}
	public Station(int station_id, String station_code, String station_name,int bicycle_pile_num, String address, String person_in_charge) {
		super();
		this.station_id = station_id;
		this.station_code = station_code;
		this.station_name = station_name;
		this.bicycle_pile_num = bicycle_pile_num;
		this.address = address;
		this.person_in_charge = person_in_charge;
	}
	
	

}
