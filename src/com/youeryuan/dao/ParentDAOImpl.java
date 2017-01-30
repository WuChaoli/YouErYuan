package com.youeryuan.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Parent;
import com.youeryuan.entity.School;
import com.youeryuan.idao.ParentDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("parentDAO")
public class ParentDAOImpl implements ParentDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertParent(Parent parent) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.ParentMapper.insertParent", parent);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int insertChildOfParent(int parentId, int childId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("parentId", parentId);
		hashmap.put("childId", childId);
		int affect = session.insert("com.youeryuan.entity.ParentMapper.insertChildOfParent", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int insertLoveSchoolOfParent(int parentId, int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("parentId", parentId);
		hashmap.put("schoolId", schoolId);
		int affect = session.insert("com.youeryuan.entity.ParentMapper.insertLoveSchoolOfParent", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateParentSimpleData(Parent parent) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ParentMapper.updateParentSimpleData", parent);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateParentAddress(Parent parent) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ParentMapper.updateParentAddress", parent);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateParentPassword(Parent parent) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ParentMapper.updateParentPassword", parent);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	//----------------------------------------select------------------------------------------------
	
	@Override
	public Parent selectParentById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Parent parent = session.selectOne("com.youeryuan.entity.ParentMapper.selectParentById", id);
		session.close();
		return parent;
	}

	@Override
	public Parent selectParentByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Parent parent = session.selectOne("com.youeryuan.entity.ParentMapper.selectParentByUsername", username);
		session.close();
		return parent;
	}
	
	@Override
	public int selectCountParentByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.selectOne("com.youeryuan.entity.ParentMapper.selectCountParentByUsername", username);
		session.close();
		return affect;
	}

	@Override
	public List<Parent> selectParentsByName(String name) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Parent> parents = session.selectList("com.youeryuan.entity.ParentMapper.selectParentsByName", name);
		session.close();
		return parents;
	}

	@Override
	public List<Parent> selectParentsByAddress(Parent parent) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Parent> parents = session.selectList("com.youeryuan.entity.ParentMapper.selectParentsByAddress", parent);
		session.close();
		return parents;
	}

	@Override
	public List<Child> selectChildrenByParentId(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Child> children = session.selectList("com.youeryuan.entity.ParentMapper.selectChildrenByParentId", id);
		session.close();
		return children;
	}
	
	@Override
	public List<School> selectLoveSchoolsByParentId(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<School> schools = session.selectList("com.youeryuan.entity.ParentMapper.selectLoveSchoolsByParentId", id);
		session.close();
		return schools;
	}

	@Override
	public List<Parent> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Parent> parents = session.selectList("com.youeryuan.entity.ParentMapper.selectAll");
		session.close();
		return parents;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteParentById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteParentById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int deleteParentByUsername(String username) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteParentByUsername", username);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteChildOfParent(int parentId, int childId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("parentId", parentId);
		hashmap.put("childId", childId);
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteChildOfParent", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int deleteAllChildrenOfParent(int parentId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteAllChildrenOfParent", parentId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteLoveSchoolOfParent(int parentId, int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("parentId", parentId);
		hashmap.put("schoolId", schoolId);
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteLoveSchoolOfParent", hashmap);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteAllLoveSchoolsOfParent(int parentId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ParentMapper.deleteAllLoveSchoolsOfParent", parentId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
