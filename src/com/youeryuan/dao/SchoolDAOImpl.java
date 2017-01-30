package com.youeryuan.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Clazz;
import com.youeryuan.entity.School;
import com.youeryuan.idao.SchoolDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("schoolDAO")
public class SchoolDAOImpl implements SchoolDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertSchool(School school) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.SchoolMapper.insertSchool", school);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int insertChildOfSchool(int childId, int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("childId", childId);
		hashmap.put("schoolId", schoolId);
		int affect = session.insert("com.youeryuan.entity.SchoolMapper.insertChildOfSchool", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSchoolSimpleData(School school) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.SchoolMapper.updateSchoolSimpleData", school);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateSchoolAddress(School school) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.SchoolMapper.updateSchoolAddress", school);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateSchoolPassword(School school) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.SchoolMapper.updateSchoolPassword", school);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public School selectSchoolById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		School school = session.selectOne("com.youeryuan.entity.SchoolMapper.selectSchoolById", id);
		session.close();
		return school;
	}

	@Override
	public School selectSchoolByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		School school = session.selectOne("com.youeryuan.entity.SchoolMapper.selectSchoolByUsername", username);
		session.close();
		return school;
	}
	
	@Override
	public int selectCountSchoolByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.selectOne("com.youeryuan.entity.SchoolMapper.selectCountSchoolByUsername", username);
		session.close();
		return affect;
	}

	@Override
	public List<School> selectSchoolsByName(String name) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<School> schools = session.selectList("com.youeryuan.entity.SchoolMapper.selectSchoolsByName", name);
		session.close();
		return schools;
	}

	@Override
	public List<School> selectSchoolsByAddress(School school) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<School> schools = session.selectList("com.youeryuan.entity.SchoolMapper.selectSchoolsByAddress", school);
		session.close();
		return schools;
	}
	
	@Override
	public List<Child> selectChildrenBySchoolId(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Child> children = session.selectList("com.youeryuan.entity.SchoolMapper.selectChildrenBySchoolId", id);
		session.close();
		return children;
	}

	@Override
	public int selectCountBeenLovedBySchoolId(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int count = session.selectOne("com.youeryuan.entity.SchoolMapper.selectCountBeenLovedBySchoolId", id);
		session.close();
		return count;
	}
	
	@Override
	public List<Clazz> selectClassesBySchoolId(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> Classes = session.selectList("com.youeryuan.entity.SchoolMapper.selectClassesBySchoolId", id);
		session.close();
		return Classes;
	}

	@Override
	public List<School> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<School> schools = session.selectList("com.youeryuan.entity.SchoolMapper.selectAll");
		session.close();
		return schools;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteSchoolById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.SchoolMapper.deleteSchoolById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteSchoolByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.SchoolMapper.deleteSchoolByUsername", username);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteChildOfSchool(int childId, int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("childId", childId);
		hashmap.put("schoolId", schoolId);
		int affect = session.delete("com.youeryuan.entity.SchoolMapper.deleteChildOfSchool", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int deleteAllChildrenOfSchool(int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.SchoolMapper.deleteAllChildrenOfSchool", schoolId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteAllParentsOfSchool(int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.SchoolMapper.deleteAllParentsOfSchool", schoolId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
