package com.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.po.CustomerInfo;
import com.service.biz.BizService;


@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class CustmerRegisterAction {
	private String path;
	private CustomerInfo customerInfo;
	private Integer custId;
	@Resource(name = "BizService")
	private BizService bizService;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	@Action(value = "show_CustomerRegister",results={@Result(name = "ok",type = "redirect",location = "${path}")
	
	})
	public String show(){
		boolean flag = bizService.getCustomerInfoBiz().save(customerInfo);
		try {
			if (flag) {
				path = "show_InitSevert";
				return "ok";
			}else{
				path = "Register.jsp";
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
