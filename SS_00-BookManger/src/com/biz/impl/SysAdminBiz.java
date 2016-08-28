package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ISysAdminBiz;
import com.po.SysAdmin;
import com.service.dao.DaoService;
@Transactional
@Service("SysAdminBiz")
public class SysAdminBiz implements  ISysAdminBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	public boolean save(SysAdmin sysAdmin) {
			try {
				daoService.getSysAdminDAO().save(sysAdmin);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	public boolean update(SysAdmin sysAdmin) {
		try {
			daoService.getSysAdminDAO().merge(sysAdmin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delById(int adminId) {
		try {
		SysAdmin sysAdmin =	daoService.getSysAdminDAO().findById(adminId);
		daoService.getSysAdminDAO().delete(sysAdmin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}     
	
@Transactional(propagation =Propagation.NOT_SUPPORTED)
	public SysAdmin findById(int adminId) {
		return daoService.getSysAdminDAO().findById(adminId);
	}
@Transactional(propagation =Propagation.NOT_SUPPORTED)
	public int pageCount(int pageSize) {
		if (pageSize<1) pageSize=5;
	return  daoService.getSysAdminDAO().findMaxPage(pageSize);
	}
	
@Transactional(propagation =Propagation.NOT_SUPPORTED)	
  public List<SysAdmin> getnowPageDate(int nowPage, int pageSize) {
	if(nowPage<1)nowPage=1;
	if(pageSize<1)pageSize=5;
	return daoService.getSysAdminDAO().findAll(nowPage, pageSize);
	}
	
@Transactional(propagation =Propagation.NOT_SUPPORTED)
	public List<SysAdmin> findAll() {
	
		return daoService.getSysAdminDAO().findAll();
	}
@Transactional(propagation =Propagation.NOT_SUPPORTED)
	public SysAdmin findNameAndPwd(String adminName, String pwd) {
	return daoService.getSysAdminDAO().findNameAndPwd(adminName, pwd);
	}
@Transactional(propagation =Propagation.NOT_SUPPORTED)
	public List<SysAdmin> getnowPageData(int nowPage, int pageSize) {
		if(nowPage<1)nowPage=1;
		if(pageSize<1)pageSize=5;
		return daoService.getSysAdminDAO().findAll(nowPage, pageSize);
}



}
