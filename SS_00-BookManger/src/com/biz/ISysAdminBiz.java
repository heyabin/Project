package com.biz;

import java.util.List;

import com.po.SysAdmin;
public interface ISysAdminBiz{
	public boolean save (SysAdmin sysAdmin);
	public boolean delById (int adminId);
	public boolean update (SysAdmin sysAdmin);
	public SysAdmin findById (int adminId);
	public int pageCount ( int pageSize);
	public List<SysAdmin> getnowPageData (int nowPage,int pageSize);
	public SysAdmin findNameAndPwd (String adminName,String pwd);
	public List<SysAdmin> findAll ();
}
