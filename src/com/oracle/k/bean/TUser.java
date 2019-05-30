package com.oracle.k.bean;

public class TUser {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String id_number;
	private String tel;
	private String addr;
	private int type;
	public TUser(int id, String username, String password, String sex, String id_number, String tel, String addr,
			int type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.id_number = id_number;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
	}
	
	public TUser() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TUser [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", id_number="
				+ id_number + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "]";
	}
	
}
