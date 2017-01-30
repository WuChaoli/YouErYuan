package com.youeryuan.entity;

import org.springframework.stereotype.Component;

@Component("fileUploadAndDownload")
public class FileUploadAndDownload {
	

	private int id;
	private int lessonId;
	private String originalFilename;
	private String updateFilename;
	private String date;
	
	public FileUploadAndDownload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileUploadAndDownload(int lessonId, String originalFilename, String updateFilename, String date) {
		super();
		this.lessonId = lessonId;
		this.originalFilename = originalFilename;
		this.updateFilename = updateFilename;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public String getUpdateFilename() {
		return updateFilename;
	}
	public void setUpdateFilename(String updateFilename) {
		this.updateFilename = updateFilename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
