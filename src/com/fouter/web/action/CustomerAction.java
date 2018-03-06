package com.fouter.web.action;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.catalina.core.ApplicationServletRegistration;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.fouter.domain.Customer;
import com.fouter.service.CustomerService;
import com.fouter.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;

import antlr.CSharpCodeGenerator;
import antlr.StringUtils;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService cs=new CustomerServiceImpl();
	private Customer customer=new Customer();

	public String list() throws Exception {
		String cust_name=ServletActionContext.getRequest().getParameter("cust_name");
		
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		
		if (org.apache.commons.lang3.StringUtils.isNotBlank(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		
		List<Customer> list = cs.getAll(dc);
		
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "list";
	}
	
	
	
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		cs.save(customer);
		
		return "toList";
	}



	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
}
