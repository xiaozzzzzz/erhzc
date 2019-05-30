package com.oracle.k.bean;

public class TCar {
	private int id;
	private String car_number;
	private int brand_id;
	private String model;
	private String color;
	private int category_id;
	private String t_comments;
	private double price;
	private double rent;
	private int status;
	private int useable;


	public TCar(int id, String car_number, int brand_id, String model, String color, int category_id, String t_comments,
			double price, double rent, int status, int useable) {
		super();
		this.id = id;
		this.car_number = car_number;
		this.brand_id = brand_id;
		this.model = model;
		this.color = color;
		this.category_id = category_id;
		this.t_comments = t_comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
	}

	public TCar() {
		super();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getT_comments() {
		return t_comments;
	}

	public void setT_comments(String t_comments) {
		this.t_comments = t_comments;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUseable() {
		return useable;
	}

	public void setUseable(int useable) {
		this.useable = useable;
	}

	@Override
	public String toString() {
		return id + "\t"+ car_number + "\t\t" +  brand_id + "\t\t" + model + "\t"
				+ color + "\t" + category_id + "\t\t" + t_comments + "\t\t" + price + "\t"
				+ rent + "\t" + status + "\t" + useable ;
	}
	
	public String toString0() {
		return id + "\t"+ car_number + "\t\t" +  brand_id + "\t\t" + model + "\t"
				+ color + "\t" + category_id + "\t\t" + t_comments + "\t\t" + price + "\t"
				+ rent  ;
	}
	
}
