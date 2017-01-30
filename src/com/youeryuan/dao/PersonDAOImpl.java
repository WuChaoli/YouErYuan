package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Person;
import com.youeryuan.idao.PersonDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO{
	
	//----------------------------------------insert------------------------------------------------
	
	@Override
	public int insertPerson(Person person) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.PersonMapper.insertPerson", person);
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------
	
	@Override
	public int updatePerson(Person person) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.PersonMapper.updatePerson", person);
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public Person selectPersonById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Person person = session.selectOne("com.youeryuan.entity.PersonMapper.selectPersonById", id);
		session.close();
		return person;
	}

	@Override
	public List<Person> selectPersonsByName(String name) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Person> persons = session.selectList("com.youeryuan.entity.PersonMapper.selectPersonsByName", name);
		session.close();
		return persons;
	}

	@Override
	public List<Person> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Person> persons = session.selectList("com.youeryuan.entity.PersonMapper.selectAll");
		session.close();
		return persons;
	}

	//----------------------------------------delete------------------------------------------------

	@Override
	public int deletePerson(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.PersonMapper.deletePerson", id);
		session.close();
		return affect;
	}

}
