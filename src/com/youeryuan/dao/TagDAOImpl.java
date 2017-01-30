package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Tag;
import com.youeryuan.idao.TagDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("tagDAO")
public class TagDAOImpl implements TagDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertTag(Tag tag) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.TagMapper.insertTag", tag);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSimpleData(Tag tag) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.TagMapper.updateSimpleData", tag);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public Tag selectTagById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Tag tag = session.selectOne("com.youeryuan.entity.TagMapper.selectTagById", id);
		session.close();
		return tag;
	}

	@Override
	public List<Tag> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Tag> tags = session.selectList("com.youeryuan.entity.TagMapper.selectAll");
		session.close();
		return tags;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteTagById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.TagMapper.updateSimpleData", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
