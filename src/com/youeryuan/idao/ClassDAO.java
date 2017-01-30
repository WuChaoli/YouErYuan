package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.Address;
import com.youeryuan.entity.Clazz;
import com.youeryuan.entity.Lesson;
import com.youeryuan.entity.Tag;

public interface ClassDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入科目信息
	public int insertClass(Clazz clazz) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新科目信息
	public int updateClassData(Clazz clazz) throws IOException;
	
	//更新科目进程信息
	public int updateClassProcess(Clazz clazz) throws IOException;
	
	//更新科目所属学校
	public int updateClassBelong(Clazz clazz) throws IOException;
	
	//更新科目评价信息（评分与评价人数）
	public int updateClassEvaluation(Clazz clazz) throws IOException;
	
	//更新科目类型（大分类与小分类）
	public int updateClassType(Clazz clazz) throws IOException;
 
	//更新科目人数（结业人数与在读人数）
	public int updateClassPopulation(Clazz clazz) throws IOException;
	
	//更新所有信息
	public int updateAll(Clazz clazz) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据科目编号提取科目信息
	public Clazz selectClassById(int id) throws IOException;
 
	//根据科目名称提取科目信息
	public List<Clazz> selectClassesByName(String className) throws IOException;
 
	//根据科目所属学校提取科目信息
	public List<Clazz> selectClassesBySchoolId(int schoolId) throws IOException;
	
	//根据科目课程数提取科目信息，参数：最小课程数，最大课程数
	public List<Clazz> selectClassesByClassNumber(int minNumber, int maxNumber) throws IOException;
	
	//根据科目单次课长提取科目信息
	public List<Clazz> selectClassesBySingleLessonTime(int minTime, int maxTime) throws IOException;
 
	//根据大于等于平均评分提取科目信息，参数：请求评分
	public List<Clazz> selectClassesByAverageScore(double requestScore) throws IOException;
	
	//根据科目大分类提取科目信息
	public List<Clazz> selectClassesByClassLargeType(int classLargeType) throws IOException;
 
	//根据科目小分类提取科目信息
	public List<Clazz> selectClassesByClassSmallType(int classSmallType) throws IOException;
 
	//根据班级规模提取科目信息，参数：最小班级规模，最大班级规模
	public List<Clazz> selectClassesByClassScale(int minScale, int maxScale) throws IOException;
 
	//根据在读人数提取科目信息
	public List<Clazz> selectClassesByAttendingNumber(int attendingNumber) throws IOException;
 
	//根据科目编号提取课程信息
	public List<Lesson> selectLessonsByClassId(int classId) throws IOException;
	
	//根据科目编号提取标签信息
	public List<Tag> selectTagsByClassId(int classId) throws IOException;
	
	//提取所有信息
	public List<Clazz> selectAll() throws IOException;
	
	//根据大于等于结业人数以升序分页提取科目信息，参数：毕业人数，页长，页码
	public List<Clazz> selectClassesByGraduationNumberByAscOrder(int graduationNumber, int pageSize, int pageIndex) throws IOException;
	
	//根据科目价格以升序分页提取科目信息，参数：最小价格，最大价格，页长，页码
	public List<Clazz> selectClassesByPriceByAscOrder(int minPrice, int maxPrice, int pageSize, int pageIndex)throws IOException;
	
	//根据科目价格以降序分页提取科目信息，参数：最小价格，最大价格，页长，页码
	public List<Clazz> selectClassesByPriceByDescOrder(int minPrice, int maxPrice, int pageSize, int pageIndex)throws IOException;
	
	//根据科目信用以降序分页提取科目信息，参数：页长，页码
	public List<Clazz> selectClassesByCreditByDescOrder(int pageSize, int pageIndex)throws IOException;
	
	//根据科目地址分页提取相关信息，参数：地址，页长，页码
	public List<Clazz> selectClassesByAddress(Address address, int pageSize, int pageIndex)throws IOException;
	//----------------------------------------delete------------------------------------------------
 
	//根据科目编号删除科目信息
	public int deleteClassById(int id) throws IOException;
	
	//根据学校编号删除科目信息
	public int deleteClassesBySchoolId(int schoolId) throws IOException;
 

}
