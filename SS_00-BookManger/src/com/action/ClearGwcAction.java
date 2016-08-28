package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.biz.impl.Gwc;
import com.po.BookInfo;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class ClearGwcAction {
	private String path;
	private Integer bookId;
	private BookInfo bookInfo;
	
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


	@Action(value = "show_ClearGwc",results ={@Result(name = "ok",type = "redirect",location ="${path}")
	
	})
	public String show(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		gwc.clear();
		path = "show_InitSevert";
		return "ok";
	}
}
