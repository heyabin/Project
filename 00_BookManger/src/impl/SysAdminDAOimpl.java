package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;

import dao.SysAdminDAO;
import dbutil.DButil;
import enetiy.News;
import enetiy.SysAdmin;
public class SysAdminDAOimpl implements SysAdminDAO{

	public boolean delete(int adminId) {
		boolean flag = false;;
        String sql = "update sysAdmin set isDelete = 0 where adminId ='"+adminId+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public List<SysAdmin> findAll() {
		 String sql = "select * from sysAdmin where isDelete = 1 ";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<SysAdmin> list = new Vector<SysAdmin>();
	         try {
	 			while (rs.next()) {
	 			SysAdmin  new1 = new SysAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	 			list.add(new1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}

	public SysAdmin findById(int adminId) {
		 String sql = "select * from sysAdmin where isDelete = 1 and adminId ='"+adminId+"'";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         SysAdmin new1 = null;
	         try {
	 			while (rs.next()) {
	 				new1 = new SysAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return new1 ;
	}

	public boolean modify(SysAdmin sysAdmin) {
		boolean flag = false;
        String sql = " update sysAdmin set adminName = '"+sysAdmin.getAdminName()+"', pwd = '"+sysAdmin.getPwd()+"',adminType = '"+sysAdmin.getAdminType()+"' where adminId = '"+sysAdmin.getAdminId()+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}
	

	public boolean save(SysAdmin sysAdmin) {
		boolean flag = false;
        String sql = "insert into SysAdmin(adminName,pwd,adminType) values('"+sysAdmin.getAdminName()+"','"+sysAdmin.getPwd()+"','"+sysAdmin.getAdminType()+"')";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public SysAdmin findNameAndPwd(String name, String pwd) {
		String sql = " select adminName,pwd,adminType from sysAdmin " +
				" where adminName = '"+name+"'  and pwd = '"+pwd+"'";
        DButil butil = new DButil();
         ResultSet  rs=  butil.query(sql);
         SysAdmin sysAdmin = null;
         try {
 			if (rs.next()) {
 				sysAdmin = new SysAdmin(rs.getString(1), rs.getString(2), rs.getInt(3));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return sysAdmin ;
}

	public List<SysAdmin> getnowPageDate(int nowPage, int pageSize) {
		 String sql = "select top " + pageSize +" adminId,adminName,pwd,adminType from sysAdmin  where isDelete = 1 and adminId not in( select top " +(nowPage-1)*pageSize + " adminId from sysAdmin )";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<SysAdmin> list = new Vector<SysAdmin>();
	         try {
	 			while (rs.next()) {
	 			SysAdmin  sysAdmin = new SysAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	 			list.add(sysAdmin);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}
	public int pageCount(int pageSize) {
	int rowCount =0;
	int pageConut= 0;
	String sql ="select count(*) detail from SysAdmin where isdelete = 1";
    DButil butil = new DButil();
    ResultSet rs = butil.query(sql);
    try {
		while (rs.next()) {
			rowCount = rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      pageConut = rowCount/pageSize;
      if ((rowCount%pageSize)!=0) {
		pageConut++;
	}
    return pageConut;
	}

}
