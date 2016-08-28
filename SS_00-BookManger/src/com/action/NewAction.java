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
import com.po.New;
import com.service.biz.BizService;
@Namespace("/")
@Controller
@ParentPackage("struts-default")
public class NewAction implements INewAction{
	@Resource(name ="BizService")
	private BizService bizService;
	
	private String path;
	private Integer newsId;
	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public String delById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Action(value="findById_New",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		New new1 = bizService.getNewBiz().findById(newsId);
		//获取当前页的实际记录数
		session.setAttribute("new1",new1);
		path="ShowNews.jsp";
		return "ok";
	}
	
	public String findAll() {
		return null;
	}

}
