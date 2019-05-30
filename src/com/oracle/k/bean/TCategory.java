package com.oracle.k.bean;

public class TCategory {
	private int id;
	private String name;
	public TCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TCategory() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return id + "\t" + name ;
	}
	
}
