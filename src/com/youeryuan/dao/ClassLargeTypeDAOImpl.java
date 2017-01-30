package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.ClassLargeType;
import com.youeryuan.entity.ClassSmallType;
import com.youeryuan.idao.ClassLargeTypeDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("classLargeTypeDAO")
public class ClassLargeTypeDAOImpl implements ClassLargeTypeDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertClassLargeType(ClassLargeType classLargeType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.ClassLargeTypeMapper.insertClassLargeType", classLargeType);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSimpleData(ClassLargeType classLargeType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassLargeTypeMapper.updateSimpleData", classLargeType);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	//----------------------------------------select------------------------------------------------
	
	@Override
	public ClassLargeType selectClassLargeTypeById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		ClassLargeType classLargeType = session.selectOne("com.youeryuan.entity.ClassLargeTypeMapper.selectClassLargeTypeById", id);
		session.close();
		return classLargeType;
	}

	@Override
	public List<ClassSmallType> selectClassSmallTypesByLargeTypeId(int largeTypeId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<ClassSmallType> classSmallTypes = session.selectList("com.youeryuan.entity.ClassLargeTypeMapper.selectClassSmallTypesByLargeTypeId", largeTypeId);
		session.close();
		return classSmallTypes;
	}

	@Override
	public List<ClassLargeType> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<ClassLargeType> classLargeTypes = session.selectList("com.youeryuan.entity.ClassLargeTypeMapper.selectAll");
		session.close();
		return classLargeTypes;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteClassLargeTypeById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ClassLargeTypeMapper.deleteLessonById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
