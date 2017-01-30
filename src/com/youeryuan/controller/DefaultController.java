package com.youeryuan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")	//默认控制器
public class DefaultController {
	
	//@RequestMapping(method = RequestMethod.GET)			GET����������
	@RequestMapping("")
	public String hello(Model model)
	{
		model.addAttribute("greeting", "Hello Spring MVC");
		return "helloworld";
		
		//使用redirect:/+相对路径名实现重定向
//		return "redirect:/pages/helloworld.jsp";
	}
	
	
	//可以使用参数 HttpServletRequest, HttpServletResponse
	//@RequestMapping("/others")
//	public String requestResponseExample(HttpServletRequest request,
//	           HttpServletResponse reponses, Model model) {
//	 
//	       // Todo something here
//	 
//	       return "others";
//	}
	
	//@Valid 用于检测数据是否正确，并在下一个参数返回检测结果
//	@RequestMapping(method = RequestMethod.POST)
//	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model){
//		
//		//如果出错则返回
//		if(result.hasErrors()) {
//		        return "enroll";
//		}
//
//		model.addAttribute("success", "Dear "+ student.getFirstName()+" , your Registration completed successfully");
//		return "success";
//	}
	
	//@RequestParam 用于接收请求参数
	//URL:http://localhost:8080/HelloSpringMVC/user?name=admin
/*	@RequestMapping("/user")
    public String userInfo(Model model,
            @RequestParam(value = "name", defaultValue = "Guest") String name) {
 
        model.addAttribute("name", name);
 
        if("admin".equals(name)) {
            model.addAttribute("email", "admin@yiibai.com");
        } else{
            model.addAttribute("email", "Not set");
        }
        return "userInfo";
    }*/
	
//	//以下的请求表达式
//	/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}
//	//可以对应下列网址，用于获取相关参数
//	/web/fe/default/en/document/8108/spring-mvc-for-beginners
//	/web/fe/default/vi/document/8108/spring-mvc-cho-nguoi-moi-bat-dau
/*	@RequestMapping("/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}")
    public String documentView(Model model,
            @PathVariable(value = "sitePrefix") String sitePrefix,
            @PathVariable(value = "language") String language,
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "naturalText") String naturalText) {
 
        model.addAttribute("sitePrefix", sitePrefix);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("naturalText", naturalText);
 
        String documentName = "Java tutorial for Beginners";
        if(id == 8108) {
            documentName = "Spring MVC for Beginners";
        }
 
        model.addAttribute("documentName", documentName);
 
        return "documentView";
	}*/

}
