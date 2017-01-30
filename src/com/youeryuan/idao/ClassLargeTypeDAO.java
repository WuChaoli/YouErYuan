package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.ClassLargeType;
import com.youeryuan.entity.ClassSmallType;

public interface ClassLargeTypeDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入大分类信息
	public int insertClassLargeType(ClassLargeType classLargeType) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新大分类信息
	public int updateSimpleData(ClassLargeType classLargeType) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据大分类编号提取大分类信息
	public ClassLargeType selectClassLargeTypeById(int id) throws IOException;
	
	//根据大分类编号提取小分类信息
	public List<ClassSmallType> selectClassSmallTypesByLargeTypeId(int largeTypeId) throws IOException;
  
	//提取所有信息
	public List<ClassLargeType> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
 
	//根据大分类编号删除大分类信息
	public int deleteClassLargeTypeById(int id) throws IOException;
 

}
