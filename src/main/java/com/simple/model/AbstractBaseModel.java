package com.simple.model;

public class AbstractBaseModel implements java.io.Serializable{

	private static final long serialVersionUID = -522832123597167225L;
	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AbstractBaseModel() {
	}
	
	
	
}
