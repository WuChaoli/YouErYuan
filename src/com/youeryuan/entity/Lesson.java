package com.youeryuan.entity;

import org.springframework.stereotype.Component;

@Component("lesson")
public class Lesson {
	
	protected int id;
	protected String lessonName;
	protected int classId;
	protected int lessonIndex;
	protected String startTime;
	protected String description;
	protected String createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getLessonIndex() {
		return lessonIndex;
	}
	public void setLessonIndex(int lessonIndex) {
		this.lessonIndex = lessonIndex;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descripton) {
		this.description = descripton;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}
