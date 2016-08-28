package com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import com.po.CustomerDetailInfo;
import com.po.CustomerInfo;
import com.po.GwcItem;
import com.po.OrderDetail;
import com.po.OrderMain;
import com.po.SysAdmin;
import com.service.biz.BizService;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
public class MakeOrderAction {
	private String path ;
	private CustomerInfo customerInfo;
	private CustomerDetailInfo customerDetailInfo;
	private Gwc gwc ;
	private OrderDetail orderDetail;
	private OrderMain orderMain;
	@Resource(name = "BizService")
	private BizService bizService ;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public CustomerDetailInfo getCustomerDetailInfo() {
		return customerDetailInfo;
	}

	public void setCustomerDetailInfo(CustomerDetailInfo customerDetailInfo) {
		this.customerDetailInfo = customerDetailInfo;
	}

	public Gwc getGwc() {
		return gwc;
	}

	public void setGwc(Gwc gwc) {
		this.gwc = gwc;
	}

	public OrderMain getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	@Action(value = "commit_MakeOrder",results={@Result(name = "ok",type = "redirect",location = "${path}")
	})
	public String commit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//从购物车中得到商品
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		SysAdmin sysAdmin= bizService.getSysAdminBiz().findById(1);
		//订单编号
		String orderNum = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		orderMain.setOrderNum(orderNum);
		orderMain.setSysAdmin(sysAdmin);
		orderMain.setStatus('1');
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		Collection<GwcItem> items = gwc.getItemNum();
		for (GwcItem gwcItem : items) {
			BookInfo bookInfo = bizService.getBookInfoBiz().findById(gwcItem.getBookId());
			//订单明细表
			OrderDetail orderDetail = new OrderDetail(orderMain, bookInfo, gwcItem.getNum());
			orderDetails.add(orderDetail);
		}
			orderMain.setOrderDetails(orderDetails);
			bizService.getOrderMainBiz().save(orderMain);
			session.setAttribute("orderNum", orderNum);
			session.removeAttribute("gwc"); 
			path = "makeOrderOK.jsp";
			return "ok";
	}
}
