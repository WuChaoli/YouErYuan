package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.ClassSmallType;
import com.youeryuan.idao.ClassSmallTypeDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("classSmallTypeDAO")
public class ClassSmallTypeDAOImpl implements ClassSmallTypeDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertClassSmallType(ClassSmallType classSmallType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.ClassSmallTypeMapper.insertClassSmallType", classSmallType);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSimpleData(ClassSmallType classSmallType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassSmallTypeMapper.updateSimpleData", classSmallType);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public ClassSmallType selectClassSmallTypeById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		ClassSmallType classSmallType = session.selectOne("com.youeryuan.entity.ClassSmallTypeMapper.selectClassSmallTypeById", id);
		session.close();
		return classSmallType;
	}

	@Override
	public List<ClassSmallType> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<ClassSmallType> classSmallTypes = session.selectList("com.youeryuan.entity.ClassSmallTypeMapper.selectAll");
		session.close();
		return classSmallTypes;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteClassSmallTypeById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ClassSmallTypeMapper.deleteClassSmallTypeById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteClassSmallTypesByLargeTypeId(int largeTypeId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ClassSmallTypeMapper.deleteClassSmallTypesByLargeTypeId", largeTypeId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
