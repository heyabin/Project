package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.action.IBookTypeAction;
import com.bean.PageBean;
import com.po.BookType;
import com.service.biz.BizService;
@Namespace("/")
@Controller
public class BookTypeAction implements IBookTypeAction{
	private String path;
	private BookType bookType;
	private Integer bookTypeId;
	private Integer page;
	private Integer rows;
	@Resource(name="BizService")
	private BizService bizService;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	@Action(value="save_BookType",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag = bizService.getBookTypeBiz().save(bookType);
		if (flag) {
			path = "findAll_BookType";
			return "ok";
		}
		return null;
	}
	@Action(value="update_BookType",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag = bizService.getBookTypeBiz().update(bookType);
		if (flag) {
			path = "findAll_BookType";
			return "ok";
		}
		return null;
	}
	@Action(value="delById_BookType",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		boolean flag = bizService.getBookTypeBiz().delById(bookTypeId);
		if (flag) {
			path = "findAll_BookType";
			return "ok";
		}
		
		return null;
	}
	@Action(value="findById_BookType",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		BookType oldBookType = bizService.getBookTypeBiz().findById(bookTypeId);
		session.setAttribute("oldBookType", oldBookType);
		path = "background/updateBookType.jsp";
		return "ok";
	}
	
	@Action(value="findAll_BookType",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		page=page==null?pb.getPage():page;
		rows=rows==null?pb.getRows():rows;
		//获取最大页数
		int maxpage=bizService.getBookTypeBiz().getpageCount(rows);
		if(page>maxpage)page=maxpage;
		
		//获取当前页的记录集合/rows每页记录数，page当前页数
		List<BookType> bookTypes=bizService.getBookTypeBiz().getnowPageData(rows, page);
		int num=bookTypes.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(bookTypes);
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/bookTypeList.jsp";
		return "ok";
	}
}
