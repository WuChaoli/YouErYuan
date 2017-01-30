package com.youeryuan.entity;

import org.springframework.stereotype.Component;

@Component("tag")
public class Tag {
	
	protected int id;
	protected String tagName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	

}
