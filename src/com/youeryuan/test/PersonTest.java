package com.youeryuan.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.youeryuan.entity.Child;
import com.youeryuan.entity.Clazz;
import com.youeryuan.entity.Tag;
import com.youeryuan.idao.ChildDAO;
import com.youeryuan.idao.ClassDAO;
import com.youeryuan.idao.TagDAO;
import com.youeryuan.utils.ApplicationContextUtil;

public class PersonTest {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String args[]) throws IOException
	{
		ApplicationContext context = ApplicationContextUtil.getApplicationContext();
		ChildDAO childDAO = (ChildDAO) context.getBean("childDAO");
		System.out.println(childDAO.selectChildById(3).getName());
		Child child = (Child) context.getBean("child");
		System.out.println(child.getName());
	}

}
