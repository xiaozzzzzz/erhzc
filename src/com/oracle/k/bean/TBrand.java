package com.oracle.k.bean;

public class TBrand {
	private int id;
	private String name;
	public TBrand(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TBrand() {
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
		return  id + "\t" + name ;
	}
	
}
