package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.biz.impl.Gwc;
import com.po.BookInfo;
import com.po.GwcItem;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class AddGwcItemAction {
	private Integer bookId;
	private String path;
	private BookInfo bookInfo;
	private Integer num;
	private GwcItem gwcItem;
	@Resource(name = "BizService")
	private BizService bizService;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public GwcItem getGwcItem() {
		return gwcItem;
	}
	public void setGwcItem(GwcItem gwcItem) {
		this.gwcItem = gwcItem;
	}
	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Action(value = "show_AddGwcItem",results ={@Result(name = "ok",type = "redirect",location ="${path}")
	
	})
	public String show(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		BookInfo bookInfo = bizService.getBookInfoBiz().findById(bookId);
		GwcItem item = new GwcItem(bookId, bookInfo.getBookName(), bookInfo.getSmallImg(), bookInfo.getPrice(), bookInfo.getHyprice(), 1);
		
		Gwc gwc = null;
	    //session 相当于书包，判断session中是否存在购物车
	    if (session.getAttribute("gwc")== null) {
			gwc = new Gwc();
		}else{
			gwc =(Gwc)session.getAttribute("gwc");	
		}
	    gwc.add(item);
		session.setAttribute("bookInfo", bookInfo);
		session.setAttribute("gwc", gwc);
		path = "gwc.jsp";
		return "ok";
	}
	
	@Action(value="update_AddGwcItem",results={
			@Result(location="${path}",name="ok",type="redirect")
	})
	public String update() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		gwc.updataItemNum(bookId, num);
		path = "gwc.jsp";
		return "ok";
	}
	
	
}
