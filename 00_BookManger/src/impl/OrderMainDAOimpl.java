package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.CustomerDetailInfoDAO;
import dao.CustomerInfoDAO;
import dao.OrderMainDAO;
import dbutil.DButil;

import enetiy.OrderMain;

public class OrderMainDAOimpl implements OrderMainDAO{

	public boolean delete(String orderNum) {
		boolean flag = false;;
        String sql = "update orderMain set isDelete = 0 where orderNum ='"+orderNum+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public List<OrderMain> findAll() {
		 String sql = "select * from OrderMain where isDelete =1 ";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<OrderMain> list = new Vector<OrderMain>();
	         try {
	 			while (rs.next()) {
	 		OrderMain  orderMain = new OrderMain(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
					 rs.getInt(7), rs.getString(8), rs.getDouble(9));		
	 				list.add(orderMain);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}

	public OrderMain findById(String orderNum) {
		String sql = "select * from OrderMain where isDelete = 1 and orderNum ='"+orderNum+"'";
        DButil butil = new DButil();
         ResultSet  rs=  butil.query(sql);
         OrderMain new1 = null;
 			try {
				while (rs.next()) {
					 new1 = new OrderMain( rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
							 rs.getInt(7), rs.getString(8), rs.getDouble(9));
            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			  return new1;
	}
	public boolean modify(OrderMain orderMain) {
		boolean flag = false;;
        String sql = "update orderMain set customerId = '"+orderMain.getAdminId()+"'," +
        		"customerName = '"+orderMain.getCustomerName()+"'," +
        		"tel = '"+orderMain.getTel()+"'," +
        		"address = '"+orderMain.getAddress()+"'," +
        				"status = '"+orderMain.getStatus()+"'," +
        						"adminId = '"+orderMain.getAdminId()+"'," +
        								"context = '"+orderMain.getContext()+"'," +
        							"sumprice = '"+orderMain.getSumprice()+"' where orderNum ='"+orderMain.getOrderNum()+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public boolean save(OrderMain orderMain) {
		boolean flag = false;;
        String sql = " insert into orderMain (orderNum,customerId,customerName,tel,address," +
        		"status,adminId,context,sumprice)values('"+orderMain.getOrderNum()+"'," +
        				"'"+orderMain.getCustomerId()+"','"+orderMain.getCustomerName()+"'," +
        					"'"+orderMain.getTel()+"','"+orderMain.getAddress()+"'," +
        					"'"+'0'+"'," +
        					"'"+0+"','"+orderMain.getContext()+"','"+orderMain.getSumprice()+"')";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public List<OrderMain> getnowPageData(int pageSize, int nowPage) {
		 String sql = " select top " + pageSize + " orderNum, customerId, customerName, tel,  address, status,  adminId, context, sumprice " +
		 		" from ordermain  where isdelete = 1 and orderNum not in( select top " + pageSize *(nowPage-1)+" orderNum  from ordermain  where isdelete = 1 )";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<OrderMain> list = new Vector<OrderMain>();
	         try {
	 			while (rs.next()) {
	 		OrderMain  new1 = new OrderMain( rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
	 				rs.getInt(7), rs.getString(8), rs.getDouble(9));		
	 				list.add(new1);
	 			}
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}
	

	public int getpageCount(int pageSize) {
       int pageCount=0;
       int rowCount = 0;
       String sql = "select count(*)  from OrderMain where  isdelete = 1";
       DButil butil = new DButil();
	ResultSet rs = butil.query(sql);
	try {
		while (rs.next()) {
			rowCount = (rs.getInt(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	pageCount =rowCount/ pageSize;
	if ((rowCount%pageSize)!= 0) {
		pageCount++;
	}
	return pageCount;
	}

	public boolean save(Connection newcon, OrderMain orderMain) {
		boolean flag = false;;
        String sql = "insert into orderMain (orderNum,customerId,customerName,tel,address," +
        		"status,adminId,context,sumprice)values('"+orderMain.getOrderNum()+"'," +
        				"'"+orderMain.getCustomerId()+"','"+orderMain.getCustomerName()+"'," +
        					"'"+orderMain.getTel()+"','"+orderMain.getAddress()+"','0',null,'"+orderMain.getContext()+"','"+orderMain.getSumprice()+"')";
        DButil butil = new DButil();
         int n =  butil.update(newcon, sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

}
