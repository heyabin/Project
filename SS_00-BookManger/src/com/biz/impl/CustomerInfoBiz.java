
package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICustomerInfoBiz;
import com.po.CustomerInfo;
import com.service.dao.DaoService;

@Transactional
@Service("CustomerInfoBiz")
public class CustomerInfoBiz implements ICustomerInfoBiz {
	@Resource(name = "DaoService")
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(CustomerInfo custId) {
		try {
			daoService.getCustomerInfoDAO().save(custId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean delById(int custId) {
		try {
			CustomerInfo customerInfo = daoService.getCustomerInfoDAO()
					.findById(custId);
			daoService.getCustomerInfoDAO().delete(customerInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean update(CustomerInfo customerInfo) {
		try {
			daoService.getCustomerInfoDAO().merge(customerInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CustomerInfo findById(int custId) {

		return daoService.getCustomerInfoDAO().findById(custId);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> findAll() {
		return daoService.getCustomerInfoDAO().findAll();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {

		return daoService.getCustomerInfoDAO().findMaxPage(pageSize);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getnowPageData(int pageSize, int nowPage) {
		return daoService.getCustomerInfoDAO().findAll(pageSize, nowPage);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CustomerInfo findNameAndPassword(CustomerInfo customerInfo) {
		
		return daoService.getCustomerInfoDAO().findNameAndPassword(customerInfo);
	}
	

}
