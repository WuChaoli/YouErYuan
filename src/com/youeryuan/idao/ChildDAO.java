package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Parent;
import com.youeryuan.entity.School;

public interface ChildDAO {
	//----------------------------------------insert------------------------------------------------
	
	//插入孩子信息
	public int insertChild(Child child) throws IOException;
	
	//绑定孩子与家长
	public int insertParentOfChild(int parentId, int childId) throws IOException;
	
	//绑定孩子与学校
	public int insertSchoolOfChild(int childId, int schoolId) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新孩子信息
	public int updateChildSimpleData(Child child) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据孩子编号提取孩子信息
	public Child selectChildById(int id) throws IOException;
	
	//根据孩子名字提取孩子信息
	public List<Child> selectChildrenByName(String name) throws IOException;
	
	//根据孩子编号提取相关父母信息
	public List<Parent> selectParentsByChildId(int id) throws IOException;
	
	//根据孩子编号提取相关学校信息
	public List<School> selectSchoolsByChildId(int id) throws IOException;
	
	//提取所有信息
	public List<Child> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
	
	//根据孩子编号删除孩子信息
	public int deleteChildById(int id) throws IOException;
	
	//解除孩子与指定家长的绑定
	public int deleteParentOfChild(int parentId, int childId) throws IOException;
	
	//根据孩子编号解除所有家长的绑定
	public int deleteAllParentsOfChild(int childId) throws IOException;
	
	//解除孩子与指定学校的绑定
	public int deleteSchoolOfChild(int childId, int schoolId) throws IOException;
	
	//根据孩子编号解除所有学校的绑定
	public int deleteAllSchoolsOfChild(int childId) throws IOException;
	
	
}
