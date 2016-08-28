package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import tool.DateConvernt;

import dao.CustomerInfoDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.CustomerInfo;

public class CustomerInfoimpl implements CustomerInfoDAO{

	public boolean delete(int custId) {
		boolean flag = false;
		String sql = " delete from customerInfo where custId ='"+custId+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public List<CustomerInfo> findAll() {
		
		String sql = "select custId,custName,pwd, email from  customerInfo  ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<CustomerInfo> customerInfos = new Vector<CustomerInfo>();
		try {
			while (rs.next()) {
				CustomerInfo type = new CustomerInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				customerInfos.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return customerInfos;
      }


	public CustomerInfo findById(int custId) {
		String sql = "select custId,custName,pwd, email from  customerInfo where  custId ='"+custId+"'";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		CustomerInfo type = null;
		try {
			while (rs.next()) {
				       type = new CustomerInfo(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
	public boolean save(CustomerInfo customerInfo) {
		boolean flag = false;
		String sql = "insert into customerInfo (custName,pwd,email)values('"+customerInfo.getCustName()+"'," +
				"'"+customerInfo.getPwd()+"'," +
						"'"+customerInfo.getEmail()+"') ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	
	}

	public boolean modify(CustomerInfo customerInfo) {
		boolean flag = false;
		String sql = " update customerInfo set custName  = '"+customerInfo.getCustName()+"',  " +
				" pwd  = '"+customerInfo.getPwd()+"',email = '"+customerInfo.getEmail()+"' where custId ='"+customerInfo.getCustId()+"'";
		DButil butil = new DButil();
		int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	
	}
	public List<CustomerInfo> getnowPageData(int pageSize, int nowPage) {
	String sql = "select top "+pageSize+" " +
			" custId,custName,pwd, email from CustomerInfo  where   isdelete  = 1  and custId   not in(select  top  " +pageSize*(nowPage -1)+"" +
					"  custId  from " +
			" CustomerInfo where isdelete = 1 ) ";
		DButil butil = new DButil();
		 ResultSet rs =   butil.query(sql);
		 List<CustomerInfo> list = new Vector<CustomerInfo>();
		 try {
			while (rs.next()) {
				CustomerInfo customerInfo = new CustomerInfo(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
				list.add(customerInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public int getpageCount(int pageSize) {
      int pageCount = 0;
      int rowCount = 0;
      String sql ="select  count(*)custId  from CustomerInfo where isdelete = 1";
      CustomerInfo customerInfo = null;
      DButil butil = new DButil();
      ResultSet rs=  butil.query(sql);
      
      try {
		while (rs.next()) {
			try {
				rowCount = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 pageCount =rowCount/ pageSize;
	if ((rowCount%pageSize)!= 0) {
		pageCount ++;
	}
	return pageCount;
	}

	public CustomerInfo findNameAndPassword(String name, String password) {
		CustomerInfo customerInfo = null;
		String sql = "select custId,custName,pwd, email from customerInfo where custName= '" + name + "' and pwd = '" + password + "'";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			if(rs.next()) {
			    customerInfo = new CustomerInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			butil.close();
		}
		return customerInfo;
	}
}
