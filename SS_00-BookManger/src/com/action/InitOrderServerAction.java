package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class InitOrderServerAction {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Action(value = "init_OrderSevert", results = {@Result(name ="ok", location ="${path}", type = "redirect")
	
	})
	public String init(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("customerInfo")==null) {
			path = "qtlogin.jsp";
		}else{
			path = "makeOrder.jsp";
		}
		return "ok";
	}
	
}
