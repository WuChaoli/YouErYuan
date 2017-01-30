package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.ClassSmallType;

public interface ClassSmallTypeDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入小分类信息
	public int insertClassSmallType(ClassSmallType classSmallType) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新小分类信息
	public int updateSimpleData(ClassSmallType classSmallType) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据小分类编号提取小分类信息
	public ClassSmallType selectClassSmallTypeById(int id) throws IOException;

	//提取所有信息
	public List<ClassSmallType> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------

	//根据小分类编号删除小分类信息
	public int deleteClassSmallTypeById(int id) throws IOException;

	//根据大分类编号删除所有小分类信息
	public int deleteClassSmallTypesByLargeTypeId(int largeTypeId) throws IOException;

}
