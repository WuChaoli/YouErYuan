package com.youeryuan.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("child")
public class Child extends Person {
	
	protected int studyTime;
	protected String createDate;
	protected List<Parent> parents;
	
	public int getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(int studyTime) {
		this.studyTime = studyTime;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

}
