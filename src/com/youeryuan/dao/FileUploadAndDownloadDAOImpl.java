package com.youeryuan.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.youeryuan.entity.FileUploadAndDownload;
import com.youeryuan.idao.FileUploadAndDownloadDAO;
import com.youeryuan.utils.MybatisUtil;

@Repository("fileUploadAndDownloadDAO")
public class FileUploadAndDownloadDAOImpl implements FileUploadAndDownloadDAO {
	
	//----------------------------------------insert------------------------------------------------

	@Override
	public int insertFileUploadAndDownload(FileUploadAndDownload fileUploadAndDownload) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.insert("com.youeryuan.entity.FileUploadAndDownloadMapper.insertFileUploadAndDownload", fileUploadAndDownload);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------update------------------------------------------------

	@Override
	public int updateSimpleData(FileUploadAndDownload fileUploadAndDownload) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.update("com.youeryuan.entity.FileUploadAndDownloadMapper.updateSimpleData", fileUploadAndDownload);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}
	
	//----------------------------------------select------------------------------------------------

	@Override
	public FileUploadAndDownload selectFileUploadAndDownloadById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		FileUploadAndDownload fileUploadAndDownload = session.selectOne("com.youeryuan.entity.FileUploadAndDownloadMapper.selectFileUploadAndDownloadById", id);
		session.close();
		return fileUploadAndDownload;
	}

	@Override
	public List<FileUploadAndDownload> selectFileUploadAndDownloadsByLessonId(int lessonId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		List<FileUploadAndDownload> fileUploadAndDownloads = session.selectList(
				"com.youeryuan.entity.FileUploadAndDownloadMapper.selectFileUploadAndDownloadsByLessonId", lessonId);
		session.close();
		return fileUploadAndDownloads;
	}
	
	//----------------------------------------delete------------------------------------------------

	@Override
	public int deleteFileUploadAndDownloadById(int id) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.FileUploadAndDownloadMapper.deleteFileUploadAndDownloadById", id);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

	@Override
	public int deleteFileUploadAndDownloadsByLessonId(int lessonId) throws IOException {
		SqlSession session = MybatisUtil.getSession();
		int affect = session.delete("com.youeryuan.entity.FileUploadAndDownloadMapper.deleteFileUploadAndDownloadsByLessonId", lessonId);
		//重要步骤，记得提交
		session.commit();
		session.close();
		return affect;
	}

}
