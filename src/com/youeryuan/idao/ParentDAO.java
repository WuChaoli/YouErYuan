package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Parent;
import com.youeryuan.entity.School;

public interface ParentDAO {
	//----------------------------------------insert------------------------------------------------
	
	//插入父母信息
	public int insertParent(Parent parent) throws IOException;
	
	//绑定父母与孩子
	public int insertChildOfParent(int parentId, int childId) throws IOException;
	
	//绑定父母与学校
	public int insertLoveSchoolOfParent(int parentId, int schoolId) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新父母信息
	public int updateParentSimpleData(Parent parent) throws IOException;
  
	//更新父母地址
	public int updateParentAddress(Parent parent) throws IOException;
 
	//更新父母密码
	public int updateParentPassword(Parent parent) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据父母编号提取父母信息
	public Parent selectParentById(int id) throws IOException;
  
	//根据用户名提取父母信息
	public Parent selectParentByUsername(String username) throws IOException;
	
	public int selectCountParentByUsername(String username) throws IOException;
	
	//根据父母姓名提取父母信息
	public List<Parent> selectParentsByName(String name) throws IOException;
 
	//根据父母地址提取父母信息
	public List<Parent> selectParentsByAddress(Parent parent) throws IOException;
	
	//根据父母编号提取孩子信息
	public List<Child> selectChildrenByParentId(int id) throws IOException;
	
	//根据父母编号提取学校信息
	public List<School> selectLoveSchoolsByParentId(int id) throws IOException;
 
	//提取所有信息
	public List<Parent> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
	
	//根据父母编号删除父母信息
	public int deleteParentById(int id) throws IOException;
	
	//根据父母用户名删除父母信息
	public int deleteParentByUsername(String username) throws IOException;
	
	//解除父母与指定孩子的绑定
	public int deleteChildOfParent(int parentId, int childId) throws IOException;
	
	//解除父母与所有孩子的绑定
	public int deleteAllChildrenOfParent(int parentId) throws IOException;
	
	//解除父母与指定学校的绑定
	public int deleteLoveSchoolOfParent(int parentId, int schoolId) throws IOException;
	
	//解除父母与所有学校的绑定
	public int deleteAllLoveSchoolsOfParent(int parentId) throws IOException;
	
	
}
