package com.fred.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fred.action.CustomerAddAction;
import com.fred.action.WebAction;

/**
 * Servlet implementation class WebController
 */
@WebServlet("/action")
public class WebController extends HttpServlet {
	private Map map;
	
	public WebController() {
		map = new HashMap();
		map.put("CustomerAdd", CustomerAddAction.class);
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����action����
		String action = request.getParameter("action");
		//�ж��Ƿ�Ϊ�գ��Ƿ�Ϊnull
		if(action != null && !"".equals(action)) {
			//ȡ����Ӧ��ҵ���������
			Class actionClass = (Class) map.get(action);
			//��ø����ʵ����������ǿ������ת��
			try {
				WebAction webAction = (WebAction)(actionClass.newInstance());
				webAction.execute(this,request,response);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
}
