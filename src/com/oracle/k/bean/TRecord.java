package com.oracle.k.bean;

public class TRecord {
	private int id;
	private int user_id;
	private int car_id;
	private String start_date;
	private String return_date;
	private double  payment;
	public TRecord(int id, int user_id, int car_id, String start_date, String return_date, double payment) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.car_id = car_id;
		this.start_date = start_date;
		this.return_date = return_date;
		this.payment = payment;
	}
	public TRecord() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return id + "\t" + user_id + "\t" + car_id + "\t" + start_date + "\t"+ return_date + "\t" + payment ;
	}
	
}
