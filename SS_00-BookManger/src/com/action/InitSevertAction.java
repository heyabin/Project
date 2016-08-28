package com.action;

import java.util.HashMap;
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

import com.po.BookInfo;
import com.po.BookType;
import com.po.New;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class InitSevertAction {
	private BookInfo bookInfo; // 根据上架日期，销售量，推荐得到list集合
	private BookType bookType;
	private String path;
	private int rows;
	private Map<BookType, List<BookType>> maps = new HashMap<BookType, List<BookType>>();
	@Resource(name = "BizService")
	private BizService bizService;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<BookType, List<BookType>> getMaps() {
		return maps;
	}

	public void setMaps(Map<BookType, List<BookType>> maps) {
		this.maps = maps;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Action(value = "show_InitSevert", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String show() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 我们需要商品分类
		List<BookType> parentBookgetParentId = bizService.getBookTypeBiz().findByParentId(0);
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bizService.getBookTypeBiz().findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		// 上架日期获取最新书
		List<BookInfo> zxBooks = bizService.getBookInfoBiz().findBySjDate(5);
		// 根据销售量获取热销书
		List<BookInfo> rxBooks = bizService.getBookInfoBiz().findBySaleCount(5);
		// 根据销售量获取推荐书
		List<BookInfo> tjBooks = bizService.getBookInfoBiz().findAll();
		List<New> news = bizService.getNewBiz().findFbTime(9);
		session.setAttribute("maps", maps);
		session.setAttribute("zxBooks", zxBooks);
		session.setAttribute("rxBooks", rxBooks);
		session.setAttribute("tjBooks", tjBooks);
		session.setAttribute("news", news);
		path = "index.jsp";
		return "ok";
	}
}
