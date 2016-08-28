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
import com.po.BookDiscuss;
import com.service.biz.BizService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class BookDiscussAction implements IBookDiscussAction{
	private BookDiscuss bookDiscuss;
	private String path;
	private Integer disId;
	private int page;
	private int rows;
	
	@Resource(name ="BizService")
	private BizService bizService;
	
	
	public BookDiscuss getBookDiscuss() {
		return bookDiscuss;
	}
	public void setBookDiscuss(BookDiscuss bookDiscuss) {
		this.bookDiscuss = bookDiscuss;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getDisId() {
		return disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}
	
	public BizService getBizService() {
		return bizService;
	}
	
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
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
	
	@Action(value="save_BookDiscuss",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag=bizService.getBookDiscussBiz().save(bookDiscuss);
		if(flag){
			path="findAll_BookDiscuss";
			return "ok";
		}
		return null;
	}
	@Action(value="update_BookDiscuss",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag=bizService.getBookDiscussBiz().update(bookDiscuss);
		if(flag){
			path="findAll_BookDiscuss";
			return "ok";
		}
		return null;
	
	}
	@Action(value="delById_BookDiscuss",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		boolean flag= bizService.getBookDiscussBiz().delById(disId);
		if(flag){
			path="findAll_BookDiscuss";
			return "ok";
		}
		return null;
	}
	@Action(value="findById_BookDiscuss",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		BookDiscuss oldBookDiscuss = bizService.getBookDiscussBiz().findById(disId);
		session.setAttribute("oldBookDiscuss",oldBookDiscuss);
		path="background/updateBookdiscuss.jsp";
		return "ok";
	}
	@Action(value="findAll_BookDiscuss",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		//获取最大页数
		int maxpage=bizService.getBookDiscussBiz().getPageCount(rows);
		if(page>maxpage) page=maxpage;
		
		//获取当前页的记录集合/rows每页记录数，page当前页数
		List<BookDiscuss> bookDiscusses=bizService.getBookDiscussBiz().getnowPageDate(rows, page);
		int num=bookDiscusses.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(bookDiscusses);
		
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/bookdiscussList.jsp";
		return "ok";
	}


}
