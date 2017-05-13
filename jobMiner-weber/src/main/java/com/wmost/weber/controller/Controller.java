package com.wmost.weber.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wmost.framework.security.IgnoreSecurity;

//注解让spring-MVC能扫描到
@RestController
@RequestMapping(value = "/samples ")
public class Controller {
	//注解方法为一个请求处理方法
	@IgnoreSecurity
	@RequestMapping(value = "/A", method = {RequestMethod.POST,RequestMethod.GET})
	public void A(){
		
	}
	
	//注解请求参数,形如：/B?key=value
	@IgnoreSecurity
	@RequestMapping(value = "/B", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView  B(@RequestParam("id") Long id,RedirectAttributes redirect){
		System.out.println("收到/samples/B/"+id+"请求...");
		
		redirect.addFlashAttribute("id", id);

		return new ModelAndView("redirect:/samples/C/"+id);
	}
	
	//注解路径变量,形如:/C/value
	@IgnoreSecurity
	@RequestMapping(value = "/C/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView C(@PathVariable Long id,RedirectAttributes redirect){
		
		System.out.println("收到/samples/C/"+id+"请求...");
		
		redirect.addFlashAttribute("id", id);
		
		return new ModelAndView("redirect:http://www.baidu.com");
	}
	
	//注解路径变量,形如:/C/value
	@IgnoreSecurity
	@RequestMapping(value = "/D", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView D(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("收到/samples/D/"+request.getContextPath()+"请求...");
		
		return new ModelAndView("redirect:http://www.baidu.com");
	}
}
