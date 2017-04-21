package com.ibeifeng.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class WebAction {
	
	/**
	 * ִ�з���
	 */
	public abstract void execute(HttpServlet servlet,HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * ��ת����
	 */
	public void forward(HttpServlet servlet,HttpServletRequest request, HttpServletResponse response,String page){
		//���ServletContext
		ServletContext sc = servlet.getServletContext();
		//���RequestDispatcher����ָ����תҳ��
		RequestDispatcher rdispatcher = sc.getRequestDispatcher(page);
		//ִ����ת
		try {
			rdispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
