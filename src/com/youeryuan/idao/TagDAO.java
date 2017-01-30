package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Tag;

public interface TagDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入标签信息
	public int insertTag(Tag tag) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新标签信息
	public int updateSimpleData(Tag tag) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据标签编号提取标签信息
	public Tag selectTagById(int id) throws IOException;

	//提取所有标签信息
	public List<Tag> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------

	//根据标签编号删除标签信息
	public int deleteTagById(int id) throws IOException;


}
