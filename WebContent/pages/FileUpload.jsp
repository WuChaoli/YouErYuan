<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<%-- <head>
    <base href="<%=basePath%>">
    <title>fileUpload</title>
    <script src="<%=basePath%>scripts/jquery-1.11.1.js"></script>
    <script src="<%=basePath%>scripts/ajaxfileupload.js"></script>
</head> --%>
<body>
	<h3>文件上传</h3><br>
	
	<h3>多文件上传 采用 MultipartFile[] multipartFile 上传文件方法</h3>
	<form name="form5" action="${pageContext.request.contextPath}/FileUploadAndDown/fileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="file_upload">
		<input type="file" name="file_upload">
		<input type="file" name="file_upload">
		<input type="submit" value="upload"/>
	</form>
	<hr>
	
<%-- 	
	<h3>通过 a 标签的方式进行文件下载</h3><br>
	<a href="<%=basePath%>filesOut/Download/mst.txt">通过 a 标签下载文件 mst.txt</a> --%>
	<hr>
	<h3>通过 Response 文件流的方式下载文件</h3>
	<a href="${pageContext.request.contextPath}/FileUploadAndDown/fileDownload_servlet">通过 文件流 的方式下载文件 mst.txt</a>
	
</body>
</html>