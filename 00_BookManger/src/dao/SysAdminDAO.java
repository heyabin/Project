package dao;

import java.util.List;

import enetiy.BookInfo;
import enetiy.SysAdmin;

public interface SysAdminDAO {
	public boolean save (SysAdmin sysAdmin);
	public boolean delete (int adminId);
	public boolean modify ( SysAdmin sysAdmin);
	public SysAdmin findById ( int adminId);
	
	public int pageCount ( int pageSize);
	public List<SysAdmin> getnowPageDate (int nowPage,int pageSize);
	
	public SysAdmin findNameAndPwd (String name,String pwd);
	public List<SysAdmin> findAll ();
}
