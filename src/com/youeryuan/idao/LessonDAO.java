package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Lesson;

public interface LessonDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入课程信息
	public int insertLesson(Lesson lesson) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新课程信息
	public int updateSimpleData(Lesson lesson) throws IOException;
	
	//更新课程所属科目
	public int updateClass(Lesson lesson) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据课程编号提取课程信息
	public Lesson selectLessonById(int id) throws IOException;
 
	//根据课程名字提取课程信息
	public List<Lesson> selectLessonsByLessonName(String lessonName) throws IOException;
	
	//根据科目编号提取课程信息
	public List<Lesson> selectLessonsByClassId(int classId) throws IOException;
  
	//提取所有信息
	public List<Lesson> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
 
	//根据课程编号删除课程信息
	public int deleteLessonById(int id) throws IOException;

	//根据科目编号删除所有课程信息
	public int deleteLessonByClassId(int classId) throws IOException;
 
 
}
