package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.po.CustomerDetailInfo;
import com.po.CustomerInfo;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class CustomerLoginAction {
	private String path;
	private CustomerInfo customerInfo;
	private String custName;
	private String pwd;
	private CustomerDetailInfo customerDetailInfo;
	//Action只能从界面传值。
	@Resource(name = "BizService")
	private BizService bizService;
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CustomerDetailInfo getCustomerDetailInfo() {
		return customerDetailInfo;
	}

	public void setCustomerDetailInfo(CustomerDetailInfo customerDetailInfo) {
		this.customerDetailInfo = customerDetailInfo;
	}

	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Action(value = "show_CustomerLogin", results = {@Result(name ="ok", location ="${path}", type = "redirect")
	
	})
	public String show(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		path = "qtlogin.jsp";
		CustomerInfo  tempcustomerInfo = bizService.getCustomerInfoBiz().findNameAndPassword(customerInfo);
		if (tempcustomerInfo!=null) {
			session.setAttribute("customerInfo", tempcustomerInfo);
			CustomerDetailInfo customerDetailInfo =	bizService.getCustomerDetailInfoBiz().findById(tempcustomerInfo.getCustId());
			if (customerDetailInfo!=null) {
			session.setAttribute("customerDetailInfo", customerDetailInfo);
			}
			path = "index.jsp";
		}
		return "ok";
	} 
	
	
}
