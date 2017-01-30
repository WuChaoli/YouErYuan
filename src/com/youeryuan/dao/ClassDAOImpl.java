package com.youeryuan.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.Address;
import com.youeryuan.entity.Clazz;
import com.youeryuan.entity.Lesson;
import com.youeryuan.entity.Tag;
import com.youeryuan.idao.ClassDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("classDAO")
public class ClassDAOImpl implements ClassDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertClass(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.ClassMapper.insertClass", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateClassData(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassData", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	@Override
	public int updateClassProcess(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassProcess", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateClassBelong(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassBelong", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateClassEvaluation(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassEvaluation", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateClassType(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassType", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateClassPopulation(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateClassPopulation", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int updateAll(Clazz clazz) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.ClassMapper.updateAll", clazz);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	//----------------------------------------select------------------------------------------------
	
	@Override
	public Clazz selectClassById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		Clazz clazz = session.selectOne("com.youeryuan.entity.ClassMapper.selectClassById", id);
		session.close();
		return clazz;
	}

	@Override
	public List<Clazz> selectClassesByName(String className) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByName", className);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesBySchoolId(int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesBySchoolId", schoolId);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByClassNumber(int minNumber, int maxNumber) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("minNumber", minNumber);
		hashmap.put("maxNumber", maxNumber);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByClassNumber", hashmap);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesBySingleLessonTime(int minTime, int maxTime) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("minTime", minTime);
		hashmap.put("maxTime", maxTime);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesBySingleLessonTime", hashmap);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByAverageScore(double requestScore) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByAverageScore", requestScore);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByClassLargeType(int classLargeType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByClassLargeType", classLargeType);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByClassSmallType(int classSmallType) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByClassSmallType", classSmallType);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByClassScale(int minScale, int maxScale) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("minScale", minScale);
		hashmap.put("maxScale", maxScale);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByClassScale", hashmap);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByAttendingNumber(int attendingNumber) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByAttendingNumber", attendingNumber);
		session.close();
		return clazzes;
	}

	@Override
	public List<Lesson> selectLessonsByClassId(int classId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Lesson> lessons = session.selectList("com.youeryuan.entity.ClassMapper.selectLessonsByClassId", classId);
		session.close();
		return lessons;
	}

	@Override
	public List<Tag> selectTagsByClassId(int classId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Tag> tags = session.selectList("com.youeryuan.entity.ClassMapper.selectTagsByClassId", classId);
		session.close();
		return tags;
	}

	@Override
	public List<Clazz> selectAll() throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectAll");
		session.close();
		return clazzes;
	}
	
	@Override
	public List<Clazz> selectClassesByGraduationNumberByAscOrder(int graduationNumber, int pageSize, int pageIndex) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("graduationNumber", graduationNumber);
		hashmap.put("minSize", (pageIndex-1)*pageSize);
		hashmap.put("maxSize", pageIndex*pageSize);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByGraduationNumberByAscOrder", hashmap);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByPriceByAscOrder(int minPrice, int maxPrice, int pageSize, int pageIndex)
			throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("minPrice", minPrice);
		hashmap.put("maxPrice", maxPrice);
		hashmap.put("minSize", (pageIndex-1)*pageSize);
		hashmap.put("maxSize", pageIndex*pageSize);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByPriceByAscOrder", hashmap);
		session.close();
		return clazzes;
	}

	@Override
	public List<Clazz> selectClassesByPriceByDescOrder(int minPrice, int maxPrice, int pageSize, int pageIndex)
			throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("minPrice", minPrice);
		hashmap.put("maxPrice", maxPrice);
		hashmap.put("minSize", (pageIndex-1)*pageSize);
		hashmap.put("maxSize", pageIndex*pageSize);
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByPriceByDescOrder", hashmap);
		session.close();
		return clazzes;
	}
	
	@Override
	public List<Clazz> selectClassesByCreditByDescOrder(int pageSize, int pageIndex) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clazz> selectClassesByAddress(Address address,int pageSize, int pageIndex) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("province", address.getProvince());
		hashmap.put("city", address.getCity());
		hashmap.put("county", address.getCounty());
		hashmap.put("minSize", (pageIndex-1)*pageSize+"");
		hashmap.put("maxSize", pageIndex*pageSize+"");
		List<Clazz> clazzes = session.selectList("com.youeryuan.entity.ClassMapper.selectClassesByPriceByDescOrder", hashmap);
		session.close();
		return clazzes;
	}

	//----------------------------------------delete------------------------------------------------
	
	@Override
	public int deleteClassById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ClassMapper.deleteClassById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteClassesBySchoolId(int schoolId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.ClassMapper.deleteClassesBySchoolId", schoolId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
