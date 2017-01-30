package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Person;

public interface PersonDAO {
	//----------------------------------------insert------------------------------------------------
	
	//插入人信息
	public int insertPerson(Person person) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新人信息
	public int updatePerson(Person person) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据人编号提取人信息
	public Person selectPersonById(int id) throws IOException;
	
	//根据人名字提取人信息
	public List<Person> selectPersonsByName(String name) throws IOException;
	
	//提取所有信息
	public List<Person> selectAll() throws IOException;
	
	//----------------------------------------delete------------------------------------------------
	
	//根据人编号删除人信息
	public int deletePerson(int id) throws IOException;
	

}
