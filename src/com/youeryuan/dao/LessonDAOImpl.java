package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Lesson;
import com.youeryuan.idao.LessonDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("lessonDAO")
public class LessonDAOImpl implements LessonDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertLesson(Lesson lesson) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.LessonMapper.insertLesson", lesson);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSimpleData(Lesson lesson) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.LessonMapper.updateSimpleData", lesson);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateClass(Lesson lesson) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.LessonMapper.updateClass", lesson);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public Lesson selectLessonById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Lesson lesson = session.selectOne("com.youeryuan.entity.LessonMapper.selectLessonById", id);
		session.close();
		return lesson;
	}

	@Override
	public List<Lesson> selectLessonsByLessonName(String lessonName) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Lesson> lessons = session.selectList("com.youeryuan.entity.LessonMapper.selectLessonsByLessonName", lessonName);
		session.close();
		return lessons;
	}

	@Override
	public List<Lesson> selectLessonsByClassId(int classId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Lesson> lessons = session.selectList("com.youeryuan.entity.LessonMapper.selectLessonsByClassId", classId);
		session.close();
		return lessons;
	}

	@Override
	public List<Lesson> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Lesson> lessons = session.selectList("com.youeryuan.entity.LessonMapper.selectAll");
		session.close();
		return lessons;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteLessonById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.LessonMapper.deleteLessonById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	@Override
	public int deleteLessonByClassId(int classId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.LessonMapper.deleteLessonByClassId", classId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
