package com.youeryuan.controller;

import com.youeryuan.entity.FileUploadAndDownload;
import com.youeryuan.idao.FileUploadAndDownloadDAO;
import com.youeryuan.utils.ApplicationContextUtil;
import com.youeryuan.utils.FilesHelpUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/FileUploadAndDown/*")
public class FileUploadController {
	
	private String saveRootDir = "D:"+File.separator+"files";
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private ApplicationContext context = ApplicationContextUtil.getApplicationContext();
	
	/**
	 * 多文件的上传
	 * @param request
	 * @param multipartFiles
	 * @return
	 */
	@RequestMapping(value = "fileUpload")
	@ResponseBody
	public String fileUpload_spring_list(HttpServletRequest request, @RequestParam("file_upload") MultipartFile[] multipartFiles) 
	{
		if (multipartFiles != null && multipartFiles.length > 0) 
		{
			try 
			{
				for (MultipartFile multipartFile : multipartFiles) 
				{
					if(multipartFile != null && multipartFile.getSize() > 0)
					{
						String originalFilename = multipartFile.getOriginalFilename();
						//返回更新过的文件名
						String updateFilename = FilesHelpUtil.FilesUpload_transferTo_spring(request, multipartFile, saveRootDir);
						
						try {
							//获取lessonId
							int lessonId = 1;
							FileUploadAndDownload fileUploadAndDownload = new FileUploadAndDownload(
									lessonId, originalFilename, updateFilename, format.format(new Date()));
							FileUploadAndDownloadDAO fileUploadAndDownloadDAO = (FileUploadAndDownloadDAO) context.getBean("fileUploadAndDownloadDAO");
							fileUploadAndDownloadDAO.insertFileUploadAndDownload(fileUploadAndDownload);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return "{'TFMark':'true','Msg':'upload success !'}";
			} 
			catch (Exception ee) 
			{
			return "{'TFMark':'false','Msg':'参数请求错误'}";
			}
		}
		return "{'TFMark':'false','Msg':'参数请求错误'}";
    }
	
	/**
	 * 文件的下载
	 *
	 * @param response
	 */
	@RequestMapping(value = "fileDownload_servlet")
	public void fileDownload_servlet(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			//获取文件编号
			int id = 6;
			FileUploadAndDownloadDAO fileUploadAndDownloadDAO = (FileUploadAndDownloadDAO) context.getBean("fileUploadAndDownloadDAO");
			FileUploadAndDownload fileUploadAndDownload = fileUploadAndDownloadDAO.selectFileUploadAndDownloadById(id);
		    FilesHelpUtil.FilesDownload_stream(request,response, fileUploadAndDownload.getUpdateFilename(), 
		    		fileUploadAndDownload.getOriginalFilename());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
  
	/**
	 * 查询表单中的所有元素进行上传
	 * CommonsMultipartResolver file.transferTo
	 */
//	@RequestMapping(value = "fileUpload_CommonsMultipartResolver")
//	@ResponseBody
//	public String fileUpload_CommonsMultipartResolver(HttpServletRequest request) 
//	{
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//		//检测form表单元素enctype="multipart/form-data"
//		if (multipartResolver.isMultipart(request)) 
//		{
//			//把网页request转换为多文件request
//			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//			//获取文件迭代器
//			Iterator iter = multipartRequest.getFileNames();
//			while (iter.hasNext()) 
//			{
//				//获取文件
//				multipartFile multipartFile = multipartRequest.getFile(iter.next().toString());
//				//保存文件
//				String fileName = FilesHelpUtil.FilesUpload_transferTo_spring(request, multipartFile, saveRootDir);
//				System.out.println(fileName);
//			}
//		}
//		return "upload success ! ";
//	}
  
	/**
	 * 文件流上传
	 */
//	@RequestMapping("fileUpload_stream")
//	@ResponseBody
//	public String upFile(HttpServletRequest request, @RequestParam("file_upload") MultipartFile multipartFile)
//	{
//		String filePath= FilesHelpUtil.FilesUpload_stream(request,multipartFile,saveRootDir);
//		return "{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}";
//	}
  
	
 
	
	
}
