package com.service.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.*;
import com.po.CustomerInfo;

@Service("DaoService")
public class DaoService {

	@Resource(name="SysAdminDAO")
	private SysAdminDAO sysAdminDAO;
	
	@Resource(name = "StudentDAO")
	private StudentDAO studentDAO;

	@Resource(name = "BookTypeDAO")
	private BookTypeDAO bookTypeDAO;
	@Resource(name = "BookInfoDAO")
	private BookInfoDAO bookInfoDAO;
	@Resource(name = "CustomerDetailInfoDAO")
	private CustomerDetailInfoDAO customerDetailInfoDAO;
	@Resource(name = "CustomerInfoDAO")
	private CustomerInfoDAO customerInfoDAO;
	@Resource(name = "BookDiscussDAO")
	private BookDiscussDAO bookDiscussDAO;
	@Resource(name = "OrderMainDAO")
	private OrderMainDAO orderMainDAO;
	@Resource(name = "OrderDetailDAO")
	private OrderDetailDAO orderDetailDAO;
	@Resource(name = "NewDAO")
	private NewDAO newDAO ;
	public SysAdminDAO getSysAdminDAO() {
		return sysAdminDAO;
	}

	public void setSysAdminDAO(SysAdminDAO sysAdminDAO) {
		this.sysAdminDAO = sysAdminDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public BookTypeDAO getBookTypeDAO() {
		return bookTypeDAO;
	}

	public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
		this.bookTypeDAO = bookTypeDAO;
	}

	public BookInfoDAO getBookInfoDAO() {
		return bookInfoDAO;
	}

	public void setBookInfoDAO(BookInfoDAO bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}

	public CustomerDetailInfoDAO getCustomerDetailInfoDAO() {
		return customerDetailInfoDAO;
	}

	public void setCustomerDetailInfoDAO(CustomerDetailInfoDAO customerDetailInfoDAO) {
		this.customerDetailInfoDAO = customerDetailInfoDAO;
	}

	public CustomerInfoDAO getCustomerInfoDAO() {
		return customerInfoDAO;
	}

	public void setCustomerInfoDAO(CustomerInfoDAO customerInfoDAO) {
		this.customerInfoDAO = customerInfoDAO;
	}

	public BookDiscussDAO getBookDiscussDAO() {
		return bookDiscussDAO;
	}

	public void setBookDiscussDAO(BookDiscussDAO bookDiscussDAO) {
		this.bookDiscussDAO = bookDiscussDAO;
	}

	public OrderMainDAO getOrderMainDAO() {
		return orderMainDAO;
	}

	public void setOrderMainDAO(OrderMainDAO orderMainDAO) {
		this.orderMainDAO = orderMainDAO;
	}

	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	public NewDAO getNewDAO() {
		return newDAO;
	}

	public void setNewDAO(NewDAO newDAO) {
		this.newDAO = newDAO;
	}
	
	
	
	


	
	
	
	
	
	
}
