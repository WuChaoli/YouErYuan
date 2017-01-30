package com.youeryuan.entity;

import org.springframework.stereotype.Component;

@Component("classSmallType")
public class ClassSmallType {
	
	protected int id;
	protected int largeTypeId;
	protected String typeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLargeTypeId() {
		return largeTypeId;
	}
	public void setLargeTypeId(int largeTypeId) {
		this.largeTypeId = largeTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

}
