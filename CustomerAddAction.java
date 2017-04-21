package com.fred.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fred.dao.CustomerDAO;
import com.fred.daofactory.CustomerDAOFactory;
import com.fred.vo.Customer;

public class CustomerAddAction extends WebAction {

	/**
	 * ִ�з���
	 */
	public void execute(HttpServlet servlet,HttpServletRequest request, HttpServletResponse response) {
		//���DAOʵ��
		CustomerDAO cdao = CustomerDAOFactory.getCustomerDAO();
		
		//���ܲ���
		String customercode = request.getParameter("customercode");
		String page = null;
		//�жϿͻ�����Ƿ�ռ��
		if(cdao.findByCustomerCode(customercode) == null) {
			String customername = request.getParameter("customername");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String relationman = request.getParameter("relationman");
			String other = request.getParameter("other");
			
			//��װCustomer����
			Customer customer = new Customer();
			customer.setCustomercode(customercode);
			customer.setCustomername(customername);
			customer.setPhone(phone);
			customer.setAddress(address);
			customer.setRelationman(relationman);
			customer.setOther(other);
			
			//ͨ��DAOʵ����ɿͻ����
			cdao.addCustomer(customer);
			//ִ����ת
			page = "/CustomerAdd.jsp";
		} else {
			page = "/CustomerAdd.jsp";
			//��Ӵ�����Ϣ
			request.setAttribute("error", "�ͻ���ű�ռ��");
		}
		forward(servlet, request, response, page);
	}

}
