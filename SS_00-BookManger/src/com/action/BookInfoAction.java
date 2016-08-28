package com.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.action.IBookInfoAction;
import com.bean.PageBean;
import com.po.BookInfo;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class BookInfoAction implements IBookInfoAction{
	private String path;
	private Integer bookId;
	private BookInfo bookInfo;
	
	private int page;
	private int rows;
	@Resource(name ="BizService")
	private BizService bizService;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
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
	
	

	@Action(value="save_BookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag=bizService.getBookInfoBiz().save(bookInfo);
		if(flag){
			path="findAll_BookInfo";
			return "ok";
		}
		return null;
	}
	@Action(value="update_BookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag=bizService.getBookInfoBiz().update(bookInfo);
		if(flag){
			path="findAll_BookInfo";
			return "ok";
		}
		return null;
	
	}
	@Action(value="delById_BookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		boolean flag= bizService.getBookInfoBiz().delById(bookId);
		if(flag){
			path="findAll_BookInfo";
			return "ok";
		}
		return null;
	}
	@Action(value="findById_BookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		BookInfo oldBookInfo = bizService.getBookInfoBiz().findById(bookId);
		session.setAttribute("oldBookInfo",oldBookInfo);
		path="background/updateBookInfo.jsp";
		return "ok";
	}
	@Action(value="findAll_BookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		//获取最大页数
		int maxpage=bizService.getBookInfoBiz().getpageCount(rows);
		if(page>maxpage)page=maxpage;
		
		//获取当前页的记录集合/rows每页记录数，page当前页数
		List<BookInfo> bookInfos=bizService.getBookInfoBiz().getnowPageData(rows, page);
		int num=bookInfos.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(bookInfos);
		
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/bookInfoList.jsp";
		return "ok";
	}
	
	
	
}
