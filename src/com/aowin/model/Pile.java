package com.aowin.model;

public class Pile {
	private int pile_id;
	private int vender_id;
	private String pile_code;
	private int station_id;
	private int status;
	private String install_time;
	private String disassembly_time;
	private int user_id;
	private String operator_time;
	private String bicycle_id;
	private String remark;
	private String vender_name;
	private String username;
	private String station_code;
	private int bikeId;
	
	
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVender_name() {
		return vender_name;
	}
	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
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
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(String bycicle_id) {
		this.bicycle_id = bycicle_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Pile [pile_id=" + pile_id + ", vender_id=" + vender_id + ", pile_code=" + pile_code + ", station_id="
				+ station_id + ", status=" + status + ", install_time=" + install_time + ", disassembly_time="
				+ disassembly_time + ", user_id=" + user_id + ", operator_time=" + operator_time + ", bicycle_id="
				+ bicycle_id + ", remark=" + remark + ", station_code=" + station_code +"]";
	}
	public Pile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pile(int vender_id, String pile_code, String install_time, String operator_time,String remark, String username, String station_code) {
		super();
		this.vender_id = vender_id;
		this.pile_code = pile_code;
		this.install_time = install_time;
		this.operator_time = operator_time;
		this.remark = remark;
		this.username = username;
		this.station_code = station_code;
	}
	public Pile(int pile_id, String pile_code, int status, String install_time, String operator_time, String bicycle_id,
			String remark, String vender_name, String username, int station_id) {
		super();
		this.pile_id=pile_id;
		this.pile_code = pile_code;
		this.status = status;
		this.install_time = install_time;
		this.operator_time = operator_time;
		this.bicycle_id = bicycle_id;
		this.remark = remark;
		this.vender_name = vender_name;
		this.username = username;
		this.station_id = station_id;
	}
	public Pile(int pile_id, int bikeId) {
		super();
		this.pile_id = pile_id;
		this.bikeId = bikeId;
	}
	
	
	
	
}
