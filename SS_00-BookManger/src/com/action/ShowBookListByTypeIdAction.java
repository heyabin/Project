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

import com.bean.PageBean;
import com.po.BookDiscuss;
import com.po.BookInfo;
import com.po.BookType;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class ShowBookListByTypeIdAction {
	private String path;
	private Integer page;
	private Integer rows;
	private Integer bookTypeId;
	Map<BookType,List<BookType>> maps = new Hashtable<BookType, List<BookType>>();
	@Resource(name = "BizService")
	private BizService bizService;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
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
	
	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	@Action(value="show_ShowBookListByTypeId",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String show(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		page=page==null ?pb.getPage():page;
		rows=rows==null?pb.getRows():rows;
		
		// 我们需要商品分类
		List<BookType> parentBookgetParentId = bizService.getBookTypeBiz().findByParentId(0);
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bizService.getBookTypeBiz().findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		
		// 根据销售量获取热销书
		List<BookInfo> rxBooks = bizService.getBookInfoBiz().findBySaleCount(5);
		//商品详细信息
		List<BookInfo> bookInfos = bizService.getBookInfoBiz().getnowPageData2(rows, page, bookTypeId);
		BookType bookType = bizService.getBookTypeBiz().findById(bookTypeId);
		//获取最大页数
		int maxpage = bizService.getBookInfoBiz().getpageCount2(rows, bookTypeId);
		if(page>maxpage)page=maxpage;
			pb.setMaxpage(maxpage);
			pb.setPage(page);
			pb.setRows(rows);
			pb.setPagelist(bookInfos);
			session.setAttribute("maps",maps );
			session.setAttribute("bookInfos",bookInfos);
			session.setAttribute("rxBooks",rxBooks );
			session.setAttribute("bookType", bookType);
			session.setAttribute("pb", pb);
			path = "bookInfoList.jsp";
			return "ok";
	}
}
