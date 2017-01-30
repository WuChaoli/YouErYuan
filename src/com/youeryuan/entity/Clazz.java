package com.youeryuan.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("clazz")
public class Clazz {
	
	protected int id;					
	protected String className;			
	protected int schoolId;				
	protected int classNumber;			
	protected int currentIndex;			
	protected String startDate;			
	protected int lastDays;				
	protected int singleLessonTime;		
	protected double averageScore;		
	protected int evaluationNumber;		
	protected int classLargeType;		
	protected int classSmallType;		
	protected int classScale;			
	protected int graduationNumber;		
	protected int attendingNumber;		
	protected int price;
	protected String description;		
	protected String createDate;		
	protected List<Lesson> lessons;		
	protected List<Tag> tags;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getLastDays() {
		return lastDays;
	}
	public void setLastDays(int lastDays) {
		this.lastDays = lastDays;
	}
	public int getSingleLessonTime() {
		return singleLessonTime;
	}
	public void setSingleLessonTime(int singleLessonTime) {
		this.singleLessonTime = singleLessonTime;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	public int getEvaluationNumber() {
		return evaluationNumber;
	}
	public void setEvaluationNumber(int evaluationNumber) {
		this.evaluationNumber = evaluationNumber;
	}
	public int getClassLargeType() {
		return classLargeType;
	}
	public void setClassLargeType(int classLargeType) {
		this.classLargeType = classLargeType;
	}
	public int getClassSmallType() {
		return classSmallType;
	}
	public void setClassSmallType(int classSmallType) {
		this.classSmallType = classSmallType;
	}
	public int getClassScale() {
		return classScale;
	}
	public void setClassScale(int classScale) {
		this.classScale = classScale;
	}
	public int getGraduationNumber() {
		return graduationNumber;
	}
	public void setGraduationNumber(int graduationNumber) {
		this.graduationNumber = graduationNumber;
	}
	public int getAttendingNumber() {
		return attendingNumber;
	}
	public void setAttendingNumber(int attendingNumber) {
		this.attendingNumber = attendingNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	

}
