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
import com.po.OrderMain;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class OrderMainAction implements IOrderMainAction{
	private String path;
	private OrderMain orderMain;
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

	public OrderMain getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
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

	@Action(value="save_OrderMain",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag=bizService.getOrderMainBiz().save(orderMain);
		System.out.println(flag+"---------------");
		if(flag){
			path="findAll_OrderMain";
			return "ok";
		}
		return null;
	}
	@Action(value="update_OrderMain",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	@Action(value="delById_OrderMain",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Action(value="findById_OrderMain",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Action(value="findAll_OrderMain",results={
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
		List<OrderMain> orderMains=bizService.getOrderMainBiz().getnowPageData(rows, page);
		System.out.println(orderMains+"------------------------====");
		int num=orderMains.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(orderMains);
		
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/orderMainList.jsp";
		return "ok";

	}


}
