package com.wmost.weber.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//注解让spring-MVC能扫描到
@RestController
@RequestMapping(value = "/samples ")
public class Controller {
	//注解方法为一个请求处理方法
	@RequestMapping(value = "/A", method = {RequestMethod.POST,RequestMethod.GET})
	public void A(){
		
	}
	
	//注解请求参数,形如：/B?key=value
	@RequestMapping(value = "/B", method = {RequestMethod.POST,RequestMethod.GET})
	public String B(@RequestParam("id") String id){
		System.out.println("收到/samples/B/"+id+"请求...");
		
		return "redirect:/C/"+id;
	}
	
	//注解路径变量,形如:/C/value
	@RequestMapping(value = "/C/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	public void C(@PathVariable String id){
		
		System.out.println("收到/samples/C/"+id+"请求...");
	}
}
