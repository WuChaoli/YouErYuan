package com.youeryuan.controller;

import java.io.IOException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.youeryuan.entity.Parent;
import com.youeryuan.entity.School;
import com.youeryuan.idao.ParentDAO;
import com.youeryuan.idao.SchoolDAO;
import com.youeryuan.utils.ApplicationContextUtil;
import com.youeryuan.utils.MailUtil;

@Controller
@RequestMapping(value={"/Login", "/Login/*", "/Register", "/Logout", "/Check/*"})
public class LogAndRegisterController {
	
	ApplicationContext context = ApplicationContextUtil.getApplicationContext();
	
	ParentDAO parentDAO = (ParentDAO) context.getBean("parentDAO");
	
	SchoolDAO schoolDAO = (SchoolDAO) context.getBean("schoolDAO");
	
	@RequestMapping(value = "/")
	public String AutoLogin(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession();
		String identity = (String) session.getAttribute("identity");
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if(identity != null && identity.trim() != "" && username != null && username.trim() != "" && password != null && password.trim() != "")
		{
			if(identity.equals("parent"))
			{
				try 
				{
					Parent parent = parentDAO.selectParentByUsername(username);
					if(password.equals(parent.getPassword()))
					{
						session.setAttribute("name", parent.getName());
						session.setAttribute("ID", parent.getId());
						return "redirect:/pages/helloworld.jsp";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(identity.equals("school"))
			{
				try 
				{
					School school = schoolDAO.selectSchoolByUsername(username);
					if(password.equals(school.getPassword()))
					{
						session.setAttribute("name", school.getName());
						session.setAttribute("ID", school.getId());
						return "redirect:/pages/helloworld.jsp";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "Login";
	}
	
	@RequestMapping(value = "/Page")
	public String PageLogin(HttpServletRequest request,@RequestParam("identity")String identity, 
			@RequestParam("username")String username, @RequestParam("password")String password, Model model)
	{
		if(identity == null || identity.trim() == "")
		{
			return "Login";
		}
		else if(username == null || username.trim() == "")
		{
			request.setAttribute("usernameMsg", "用户不能为空！");
			return "Login";
		}
		else if(password == null || password.trim() == "")
		{
			request.setAttribute("passwordMsg", "密码不能为空！");
			return "Login";
		}
		else
		{
			if(identity.equals("parent"))
			{
				try 
				{
					Parent parent = parentDAO.selectParentByUsername(username);
					if(parent == null )
					{
						request.setAttribute("usernameMsg", "用户不存在！");
						return "Login";
					}
					if(parent != null && password.equals(parent.getPassword()))
					{
						HttpSession session = request.getSession();
						session.setAttribute("identity", identity);
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						session.setAttribute("name", parent.getName());
						session.setAttribute("ID", parent.getId());
						return "redirect:/pages/helloworld.jsp";
					}
					else
					{
						request.setAttribute("passwordMsg", "密码不正确！");
						return "Login";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(identity.equals("school"))
			{
				try 
				{
					School school = schoolDAO.selectSchoolByUsername(username);
					if(school == null )
					{
						request.setAttribute("usernameMsg", "用户不存在！");
						return "Login";
					}
					if(password.equals(school.getPassword()))
					{
						HttpSession session = request.getSession();
						session.setAttribute("identity", identity);
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						session.setAttribute("name", school.getName());
						session.setAttribute("ID", school.getId());
						return "redirect:/pages/helloworld.sjp";
					}
					else
					{
						request.setAttribute("passwordMsg", "密码不正确！");
						return "Login";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "Login";
	}
	
	@RequestMapping(value = "/Register")
	public String Register(HttpServletRequest request, @RequestParam("identity")String identity, @RequestParam("username")String username, 
			@RequestParam("password")String password, @RequestParam("passwordConfirm")String passwordConfirm,@RequestParam("name")String name,
			@RequestParam("mail")String mail, Model model)
	{
		boolean isNormal = true;
		if(identity.trim().isEmpty())
		{
			isNormal = false;
		}
		else
		{
			if(!identity.equals("parent") && !identity.equals("school"))
			{
				isNormal = false;
			}
		}
		if(username.trim().isEmpty())
		{
			request.setAttribute("usernameMsg", "用户名不能为空！");
			isNormal = false;
		}
		if(password.trim().isEmpty())
		{
			request.setAttribute("passwordMsg", "密码不能为空！");
			isNormal = false;
		}
		if(passwordConfirm.trim().isEmpty())
		{
			request.setAttribute("passwordConfirmMsg", "确认密码不能为空！");
			isNormal = false;
		}
		if(!password.equals(passwordConfirm))
		{
			request.setAttribute("passwordConfirmMsg", "密码与确认密码不一致！");
			isNormal = false;
		}
		if(name.trim().isEmpty())
		{
			request.setAttribute("nameMsg", "名称不能为空！");
			isNormal = false;
		}
		if(mail.trim().isEmpty())
		{
			request.setAttribute("mailMsg", "邮箱不能为空！");
			isNormal = false;
		}
		if(mail.trim().indexOf("@") < 0)
		{
			request.setAttribute("mailMsg", "邮箱格式不正确！");
			isNormal = false;
		}
		if(!isNormal)
		{
			return "Register";
		}
		if(identity.equals("parent"))
		{
			Parent parent = new Parent();
			parent.setUsername(username);
			parent.setPassword(password);
			parent.setName(name);
			parent.setEmail(mail);
			try {
				int affect = parentDAO.selectCountParentByUsername(username);
				if(affect > 0)
				{
					request.setAttribute("usernameMsg", "用户名已存在！");
					return "Register";
				}
				else
				{
					parentDAO.insertParent(parent);
					parent = parentDAO.selectParentByUsername(username);
					HttpSession session = request.getSession();
					session.setAttribute("ID", parent.getId());
					session.setAttribute("username", parent.getUsername());
					session.setAttribute("password", parent.getPassword());
					session.setAttribute("name", parent.getName());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Register";
			}
			String checkId = UUID.randomUUID().toString();
			String mailContext = 	"<html>"+
									"<head>"+
									"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+
									"<title>Insert title here</title>"+
									"</head>"+
									"<body>"+
									"<h3><font color=\"green\" align=\"center\">柚儿圆家长账户已成功注册，点击下列连接完成验证</font></h3>"+
									"<br><br>"+
									"<a href=\"http://localhost:8080/YouErYuan/Check/Mail?id="+parent.getId()+"&identity="+identity+"&checkId="+checkId+"\">点击链接</a>"+
									"</body>"+
									"</html>";
			String[] receivers = {parent.getEmail()};
			try {
				MailUtil.sendCheckEmail(receivers, "柚儿圆", mailContext);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		else if(identity.equals("school"))
		{
			School school = new School();
			school.setUsername(username);
			school.setPassword(password);
			school.setName(name);
			school.setEmail(mail);
			try {
				int affect = schoolDAO.selectCountSchoolByUsername(username);
				if(affect > 0)
				{
					request.setAttribute("usernameMsg", "用户名已存在！");
					return "Register";
				}
				else
				{
					schoolDAO.insertSchool(school);
					school = schoolDAO.selectSchoolByUsername(username);
					HttpSession session = request.getSession();
					session.setAttribute("ID", school.getId());
					session.setAttribute("username", school.getUsername());
					session.setAttribute("password", school.getPassword());
					session.setAttribute("name", school.getName());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Register";
			}
			String checkId = UUID.randomUUID().toString();
			String mailContext = 	"<html>"+
									"<head>"+
									"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+
									"<title>Insert title here</title>"+
									"</head>"+
									"<body>"+
									"<h3><font color=\"green\" align=\"center\">柚儿圆学校账户已成功注册，点击下列连接完成验证</font></h3>"+
									"<br><br>"+
									"<a href=\"http://localhost:8080/YouErYuan/Check/Mail?id="+school.getId()+"&identity="+identity+"&checkId="+checkId+"\">点击链接</a>"+
									"</body>"+
									"</html>";
			String[] receivers = {school.getEmail()};
			try {
				MailUtil.sendCheckEmail(receivers, "柚儿圆", mailContext);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		return "redirect:/pages/RegisterSuccess.jsp";
	}
	
	@RequestMapping(value = "/Logout")
	public String Logout(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("ID");
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("name");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/Mail", method = RequestMethod.GET)
	public String MailCheck(HttpServletRequest request,@RequestParam("id")String userId, @RequestParam("identity")String identity, 
			@RequestParam("checkId")String checkId, Model model)
	{
		
		return "redirect:/";
	}

}
