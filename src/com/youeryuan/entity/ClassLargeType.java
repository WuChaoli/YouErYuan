package com.youeryuan.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("classLargeType")
public class ClassLargeType {

	protected int id;
	protected String typeName;
	protected List<ClassSmallType> classSmallTypes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<ClassSmallType> getClassSmallTypes() {
		return classSmallTypes;
	}
	public void setClassSmallTypes(List<ClassSmallType> classSmallTypes) {
		this.classSmallTypes = classSmallTypes;
	}
	
}
