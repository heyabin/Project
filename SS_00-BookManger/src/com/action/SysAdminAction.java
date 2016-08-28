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
import com.po.SysAdmin;
import com.service.biz.BizService;
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class SysAdminAction implements ISysAdminAction{
	private String path;
	private SysAdmin sysAdmin;
	private Integer adminId;
	private int page;
	private int rows;
	
	
	
	@Resource (name ="BizService")
	private BizService bizService;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public SysAdmin getSysAdmin() {
		return sysAdmin;
	}

	public void setSysAdmin(SysAdmin sysAdmin) {
		this.sysAdmin = sysAdmin;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	

	@Action(value="save_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag = bizService.getSysAdminBiz().save(sysAdmin);
		if (flag) {
			path = "findAll_SysAdmin";
			return "ok";
		}
		return null;
	}
	@Action(value="update_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag = bizService.getSysAdminBiz().update(sysAdmin);
		if (flag) {
			path = "findAll_SysAdmin";
			return "ok";
		}
		return null;
	}
	@Action(value="delById_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	
	public String delById() {
		boolean flag = bizService.getSysAdminBiz().delById(adminId);
		if (flag) {
			path = "findAll_SysAdmin";
			return "ok";
		}
		return null;
	}
	@Action(value="findById_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SysAdmin oldSysAdmin = bizService.getSysAdminBiz().findById(adminId);
		session.setAttribute("oldSysAdmin", oldSysAdmin);
		path  = "background/updateSysAdmin.jsp";
		return "ok";
	}
	@Action(value="findAll_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		PageBean pb = (PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		//获取最大页记录数
		int maxpage=bizService.getSysAdminBiz().pageCount(rows);
		if(page>maxpage) page=maxpage;
		List<SysAdmin> sysAdmins =	bizService.getSysAdminBiz().getnowPageData(page, rows);
		int num = sysAdmins.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(sysAdmins);
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/sysAdminList.jsp";
		return "ok";
	}
	@Action(value="findNameAndPwd_SysAdmin",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findNameAndPwd() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String adminName = sysAdmin.getAdminName();
		String pwd = sysAdmin.getPwd();
		path = "background/login.jsp";
		SysAdmin sysAdmin = bizService.getSysAdminBiz().findNameAndPwd(adminName, pwd);
		if (sysAdmin!=null) {
			if (sysAdmin.getAdminName()!=null&&!sysAdmin.getAdminName().trim().equals("")&&sysAdmin.getPwd()!=null&&!sysAdmin.getPwd().trim().equals("")) {
				session.setAttribute("sysAdmin", sysAdmin);
				path = "background/index.jsp";
				return "ok";
			}
		}
		return  "ok";
	}
	
}
