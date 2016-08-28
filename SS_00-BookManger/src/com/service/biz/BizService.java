package com.service.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IBookDiscussBiz;
import com.biz.IBookInfoBiz;
import com.biz.IBookTypeBiz;
import com.biz.ICustomerDetailInfoBiz;
import com.biz.ICustomerInfoBiz;
import com.biz.INewBiz;
import com.biz.IOrderDetailBiz;
import com.biz.IOrderMainBiz;
import com.biz.IStudentBiz;
import com.biz.ISysAdminBiz;
@Service("BizService")
public class BizService {

	@Resource(name = "SysAdminBiz")
	private ISysAdminBiz sysAdminBiz;
	
	@Resource(name ="StudentBiz")
	private IStudentBiz studentBiz;
	
	@Resource(name = "BookTypeBiz")
	private IBookTypeBiz bookTypeBiz;
	@Resource(name = "BookInfoBiz")
	private IBookInfoBiz bookInfoBiz;
	@Resource(name = "CustomerDetailInfoBiz")
	private  ICustomerDetailInfoBiz customerDetailInfoBiz;
	@Resource(name = "CustomerInfoBiz")
	private ICustomerInfoBiz customerInfoBiz;
	@Resource(name = "BookDiscussBiz")
	private IBookDiscussBiz bookDiscussBiz;
	@Resource(name = "OrderDetailBiz")
	private IOrderDetailBiz orderDetailBiz;
	@Resource(name = "OrderMainBiz")
	private IOrderMainBiz orderMainBiz;
	@Resource(name = "NewBiz")
	private INewBiz newBiz;
	
	
	public ISysAdminBiz getSysAdminBiz() {
		return sysAdminBiz;
	}

	public void setSysAdminBiz(ISysAdminBiz sysAdminBiz) {
		this.sysAdminBiz = sysAdminBiz;
	}

	public IStudentBiz getStudentBiz() {
		return studentBiz;
	}

	public void setStudentBiz(IStudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}

	public IBookTypeBiz getBookTypeBiz() {
		return bookTypeBiz;
	}

	public void setBookTypeBiz(IBookTypeBiz bookTypeBiz) {
		this.bookTypeBiz = bookTypeBiz;
	}

	public IBookInfoBiz getBookInfoBiz() {
		return bookInfoBiz;
	}

	public void setBookInfoBiz(IBookInfoBiz bookInfoBiz) {
		this.bookInfoBiz = bookInfoBiz;
	}

	public ICustomerDetailInfoBiz getCustomerDetailInfoBiz() {
		return customerDetailInfoBiz;
	}

	public void setCustomerDetailInfoBiz(
			ICustomerDetailInfoBiz customerDetailInfoBiz) {
		this.customerDetailInfoBiz = customerDetailInfoBiz;
	}

	public ICustomerInfoBiz getCustomerInfoBiz() {
		return customerInfoBiz;
	}

	public void setCustomerInfoBiz(ICustomerInfoBiz customerInfoBiz) {
		this.customerInfoBiz = customerInfoBiz;
	}

	public IBookDiscussBiz getBookDiscussBiz() {
		return bookDiscussBiz;
	}

	public void setBookDiscussBiz(IBookDiscussBiz bookDiscussBiz) {
		this.bookDiscussBiz = bookDiscussBiz;
	}

	public IOrderDetailBiz getOrderDetailBiz() {
		return orderDetailBiz;
	}

	public void setOrderDetailBiz(IOrderDetailBiz orderDetailBiz) {
		this.orderDetailBiz = orderDetailBiz;
	}

	public IOrderMainBiz getOrderMainBiz() {
		return orderMainBiz;
	}

	public void setOrderMainBiz(IOrderMainBiz orderMainBiz) {
		this.orderMainBiz = orderMainBiz;
	}

	public INewBiz getNewBiz() {
		return newBiz;
	}

	public void setNewBiz(INewBiz newBiz) {
		this.newBiz = newBiz;
	}
	
	
	
	

	
}
