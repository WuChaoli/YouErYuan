<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/Login/Page" method="post">
		<table>
			<tr>
				<td colspan="2" align="center">登陆界面</td>
			</tr>
			<tr>
				<td>身份：</td>
				<td>
					<select name="identity">
						<option value="parent">家长</option>
						<option value="school">学校</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>用户：</td>
				<td>
					<input type="text" name="username" value="${requestScope.username}"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><font color="red">${requestScope.usernameMsg}</font></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password" value="${requestScope.password}"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><font color="red">${requestScope.passwordMsg}</font></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登陆"/></td>
			</tr>
		
		</table>
		
	</form>

</body>
</html>