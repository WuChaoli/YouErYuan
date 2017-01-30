package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Clazz;
import com.youeryuan.entity.School;

public interface SchoolDAO {
	//----------------------------------------insert------------------------------------------------
	
	//插入学校信息
	public int insertSchool(School school) throws IOException;
	
	//绑定学校与指定孩子
	public int insertChildOfSchool(int childId, int schoolId) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新学校信息
	public int updateSchoolSimpleData(School school) throws IOException;
  
	//更新学校地址
	public int updateSchoolAddress(School school) throws IOException;
 
	//更新学校密码
	public int updateSchoolPassword(School school) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据学校编号提取学校信息
	public School selectSchoolById(int id) throws IOException;
  
	//根据学校用户名提取学校信息
	public School selectSchoolByUsername(String username) throws IOException;
	
	public int selectCountSchoolByUsername(String username) throws IOException;
	
	//根据学校名称提取学校信息
	public List<School> selectSchoolsByName(String name) throws IOException;
 
	//根据学校地址提取学校信息
	public List<School> selectSchoolsByAddress(School school) throws IOException;
	
	//根据学校编号提取孩子少量信息
	public List<Child> selectChildrenBySchoolId(int id) throws IOException;
	
	//根据学校编号提取受关注人数
	public int selectCountBeenLovedBySchoolId(int id) throws IOException;
	
	//根据学校编号提取科目信息
	public List<Clazz> selectClassesBySchoolId(int id) throws IOException;
	
	//提取所有学校信息
	public List<School> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
	
	//根据学校编号删除学校信息
	public int deleteSchoolById(int id) throws IOException;
	
	//根据学校用户名删除学校信息
	public int deleteSchoolByUsername(String username) throws IOException;
	
	//解除学校与指定孩子的绑定
	public int deleteChildOfSchool(int childId, int schoolId) throws IOException;
	
	//解除学校与所有孩子的绑定
	public int deleteAllChildrenOfSchool(int schoolId) throws IOException;
	
	//解除孩子与所有父母的绑定
	public int deleteAllParentsOfSchool(int schoolId) throws IOException;

}
