package com.youeryuan.idao;

import java.io.IOException;
import java.util.List;

import com.youeryuan.entity.FileUploadAndDownload;

public interface FileUploadAndDownloadDAO {
	
	//----------------------------------------insert------------------------------------------------
	
	//插入文件信息
	public int insertFileUploadAndDownload(FileUploadAndDownload fileUploadAndDownload) throws IOException;
	
	//----------------------------------------update------------------------------------------------
	
	//更新文件信息
	public int updateSimpleData(FileUploadAndDownload fileUploadAndDownload) throws IOException;
	
	//----------------------------------------select------------------------------------------------
	
	//根据文件编号提取文件信息
	public FileUploadAndDownload selectFileUploadAndDownloadById(int id) throws IOException;
	
	//根据课程编号提取文件信息
	public List<FileUploadAndDownload> selectFileUploadAndDownloadsByLessonId(int lessonId) throws IOException;
	
	//----------------------------------------delete------------------------------------------------
	
	//根据文件编号删除文件信息
	public int deleteFileUploadAndDownloadById(int id) throws IOException;
	
	//根据课程编号删除文件信息
	public int deleteFileUploadAndDownloadsByLessonId(int lessonId) throws IOException;
 

}
