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
import com.po.CustomerDetailInfo;
import com.service.biz.BizService;
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class CustomerDetailInfoAction implements ICustomerDetailInfoAction{
	private String path;
	private Integer custId;
	private int rows =0;
	private int page =0;
	private CustomerDetailInfo customerDetailInfo;
	@Resource(name = "BizService")
	private BizService bizService;
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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

	
	@Action(value="save_CustomerDetailInfo",results={
			@Result(location="${path}",name="ok",type="redirect")
	})
	public String save() {
	boolean flag = bizService.getCustomerDetailInfoBiz().save(customerDetailInfo);
	System.out.println(flag+"pppppppppppppppppppppp");
			if (flag) {
				System.out.println(flag+"----------------");
				path = "findAll_CustomerDetailInfo";
				return "ok";
			}
		
		return null;
	}
@Action(value = "update_CustomerDetailInfo",results = {@Result(name = "ok",type="redirect",location="${path}")
	
	})
	public String update() {
		boolean flag = bizService.getCustomerDetailInfoBiz().update(customerDetailInfo);
		if (flag) {
			path = "findAll_CustomerDetailInfo";
			return "ok";
		}
	
	return null;
	}
@Action(value = "delById_CustomerDetailInfo",results = {@Result(name = "ok",type="redirect",location="${path}")
	
	})
	public String delById() {
		boolean flag = bizService.getCustomerDetailInfoBiz().delById(custId);
		if (flag) {
			path = "findAll_CustomerDetailInfo";
			return "ok";
		}
	
		return null;
	}
	@Action(value = "findById_CustomerDetailInfo",results = {@Result(name = "ok",type="redirect",location="${path}")
	
	})
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CustomerDetailInfo oldCustomerDetailInfo = 	bizService.getCustomerDetailInfoBiz().findById(custId);
		session.setAttribute("oldCustomerDetailInfo",oldCustomerDetailInfo);
		path = "background/updateCustomerDetailInfo.jsp";
		return "ok";
	}
	@Action(value="findAll_CustomerDetailInfo",results={
			@Result(location="${path}",name="ok",type="redirect")
	})
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		//获取最大页数
		int maxpage=bizService.getBookInfoBiz().getpageCount(rows);
		if(page>maxpage)page=maxpage;
		
		//获取当前页的记录集合/rows每页记录数，page当前页数
		List<CustomerDetailInfo> customerDetailInfos=bizService.getCustomerDetailInfoBiz().getnowPageData(rows, page);
		int num=customerDetailInfos.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(customerDetailInfos);
		
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/customerDetailInfoList.jsp";
		return "ok";
	}


}
