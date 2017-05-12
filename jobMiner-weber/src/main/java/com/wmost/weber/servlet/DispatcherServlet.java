package com.wmost.weber.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 自建DispatcherServlet
	 */
	private static final long serialVersionUID = 5502952217292106276L;

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		process(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		process(request,response);
	}
	
	private void process(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//1.获取URI
		
		//2.适配相应的Controller
		
		//3.适配相应的Model获取数据
		
		//4.适配相应的View返回视图
	}
}
