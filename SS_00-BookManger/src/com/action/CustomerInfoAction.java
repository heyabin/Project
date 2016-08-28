package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.bean.PageBean;
import com.po.CustomerInfo;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class CustomerInfoAction implements ICustomerInfoAction{
	private String path;
	private CustomerInfo customerInfo;
	private Integer rows;
	private Integer page;
	private Integer custId;
	@Resource(name="BizService")
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

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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
	@Action(value="save_CustomerInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag = bizService.getCustomerInfoBiz().save(customerInfo);
		try {
			if (flag) {
				path = "findAll_CustomerInfo";
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action(value="update_CustomerInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag = bizService.getCustomerInfoBiz().update(customerInfo);
		try {
			if (flag) {
				path = "findAll_CustomerInfo";
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action(value="delById_CustomerInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		boolean flag = bizService.getCustomerInfoBiz().delById(custId);
		try {
			if (flag) {
				path = "findAll_CustomerInfo";
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action(value="findById_CustomerInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CustomerInfo oldCustomerInfo = bizService.getCustomerInfoBiz().findById(custId);
		session.setAttribute("oldCustomerInfo", oldCustomerInfo);
		path = "background/updateCustomerInfo.jsp";
		return "ok";
	}

	@Action(value="findAll_CustomerInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
	HttpSession session = ServletActionContext.getRequest().getSession();
	PageBean pb=(PageBean) session.getAttribute("pb");
	pb=pb==null?new PageBean():pb;
	
	page=page==null?pb.getPage():page;
	rows=rows==null?pb.getRows():rows;
	//获得最大页数
	int maxpage = bizService.getCustomerInfoBiz().getpageCount(rows);
	if(page>maxpage)page=maxpage;
	
	List<CustomerInfo> customerInfos = bizService.getCustomerInfoBiz().getnowPageData(rows, page);
	
	int num = customerInfos.size();
	
	pb.setMaxpage(maxpage);
	pb.setPage(page);
	pb.setPagelist(customerInfos);
	pb.setRows(rows);
	
	session.setAttribute("pb",pb);
	session.setAttribute("num",num);
	path="background/customerInfoList.jsp";
	return "ok";
	}


}
