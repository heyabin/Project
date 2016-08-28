package test;

import impl.NewDAOimpl;
import impl.SysAdminDAOimpl;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;
import dao.NewDAO;
import dao.SysAdminDAO;
import enetiy.News;
import enetiy.SysAdmin;

public class SysAdminDAOTest {
	public static void main(String[] args) {
		//testsave();
    	//testdelete();
    	//testupdate();
    	//testfindById();
    	//testfiandAll();
    	//testfin();
    	//testfian();
    	testfi();
    }
	public static void testfi(){
        int pageSize = 3;
        int nowPage = 2;
	 	 SysAdminDAO dao = new SysAdminDAOimpl();
         List<SysAdmin> list = dao.getnowPageDate(nowPage, pageSize);
         for (SysAdmin sysAdmin : list) {
			System.out.println(sysAdmin);
		}
         
	}
	 public static void testfian(){
         int pageSize = 1;
		 SysAdminDAO dao = new SysAdminDAOimpl();
         System.out.println(dao.pageCount(pageSize));
	}

	 public static void testfin(){
			String name  ="admin";
			String pwd  ="admin";
	        SysAdminDAO dao = new SysAdminDAOimpl();
	  		System.out.println(dao.findNameAndPwd(name, pwd)); 

	}
	public static void testsave(){
		boolean isDelete = false;
		SysAdmin sysAdmin = new SysAdmin("hh", "gg", 1);
		SysAdminDAO dao = new SysAdminDAOimpl();
	 System.out.println(dao.save(sysAdmin));  
	}
	public static void testdelete(){
			int adminId = 12;
			SysAdminDAO dao = new SysAdminDAOimpl();
			System.out.println(dao.delete(adminId)); 
	 }
	 public static void testupdate(){
		 SysAdmin sysAdmin = new SysAdmin("ss","dd", 3);	
          sysAdmin.setAdminId(13);
          SysAdminDAO dao = new SysAdminDAOimpl();
		System.out.println(dao.modify(sysAdmin)); 
		}
	 public static void testfindById(){
			int adminId =13;
	        SysAdminDAO dao = new SysAdminDAOimpl();
	  		System.out.println(dao.findById(adminId)); 

	}
	 public static void testfiandAll(){
		 SysAdminDAO dao = new SysAdminDAOimpl();
		 List<SysAdmin>list = dao.findAll();
		 for (SysAdmin sysAdmin : list) {
			System.out.println(sysAdmin);
		}
		}
}
