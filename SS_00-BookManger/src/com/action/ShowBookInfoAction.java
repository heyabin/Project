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

import com.po.BookDiscuss;
import com.po.BookInfo;
import com.po.BookType;
import com.service.biz.BizService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class ShowBookInfoAction {
	private String path;
	private BookInfo bookInfo;
	private BookType bookType;
	private BookDiscuss bookDiscuss;
	private Integer rows;
	private Integer page;
	private Integer bookId;
	Map<BookType,List<BookType>> maps = new Hashtable<BookType, List<BookType>>();
	
	
	@Resource(name = "BizService")
	private BizService bizService;

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

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
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

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public BookDiscuss getBookDiscuss() {
		return bookDiscuss;
	}

	public void setBookDiscuss(BookDiscuss bookDiscuss) {
		this.bookDiscuss = bookDiscuss;
	}

	@Action(value="show_ShowBookInfo",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String show(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//我们需要商品分类
		List<BookType> parentBookgetParentId = bizService.getBookTypeBiz().findByParentId(0);
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bizService.getBookTypeBiz().findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		//得到该商品的具体信息
		BookInfo boofoInfo = bizService.getBookInfoBiz().findById(bookId);
		//根据销售量获取热销书
	    List<BookInfo> 	rxBooks = bizService.getBookInfoBiz().findBySaleCount(5);
		//评论
		List<BookDiscuss> bookDiscusses = bizService.getBookDiscussBiz().findByBookId(bookId);
		int num = bookDiscusses.size();
		session.setAttribute("maps",maps);
		session.setAttribute("rxBooks",rxBooks);
		session.setAttribute("boofoInfo", boofoInfo);
		session.setAttribute("bookDiscusses", bookDiscusses);
		session.setAttribute("num", num);
		path = "bookInfo.jsp";
		return "ok";
	}
	
}
