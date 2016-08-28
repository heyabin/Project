package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICustomerDetailInfoBiz;
import com.po.CustomerDetailInfo;
import com.service.dao.DaoService;
@Transactional
@Service("CustomerDetailInfoBiz")
public class CustomerDetailInfoBiz implements ICustomerDetailInfoBiz{
	@Resource(name ="DaoService")
	private DaoService daoService ;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(CustomerDetailInfo customerDetailInfo) {
		try {
			daoService.getCustomerDetailInfoDAO().save(customerDetailInfo);
			System.out.println("oooooooooooooooooooooo");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(int custId) {
		try {
		CustomerDetailInfo oldcustomerDetailInfo =	daoService.getCustomerDetailInfoDAO().findById(custId);
		daoService.getCustomerDetailInfoDAO().delete(oldcustomerDetailInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(CustomerDetailInfo customerDetailInfo) {
		try {
			daoService.getCustomerDetailInfoDAO().merge(customerDetailInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CustomerDetailInfo findById(int custId) {
		return daoService.getCustomerDetailInfoDAO().findById(custId);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {
		//if(pageSize<1)pageSize=5;
		return daoService.getCustomerDetailInfoDAO().findMaxPage(pageSize);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerDetailInfo> getnowPageData(int pageSize, int nowPage) {
		if (nowPage<1) nowPage =1;
		if (pageSize<1) pageSize=3;
		return daoService.getCustomerDetailInfoDAO().findAll(nowPage, pageSize);
	}
	public List<CustomerDetailInfo> findAll() {

		return daoService.getCustomerDetailInfoDAO().findAll();
	}

}
