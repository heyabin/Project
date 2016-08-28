package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.spi.ResolveResult;

import dao.OrderDetailDAO;
import dao.OrderMainDAO;
import dbutil.DButil;
import enetiy.OrderDetail;
import enetiy.OrderMain;

public class OrderDetailDAOimpl implements OrderDetailDAO{

	public boolean delete(int detailId) {
		String sql = "delete from orderDetail where detail = '"+detailId+"'";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public List<OrderDetail> findAll() {
       String sql = "select detail,orderNum, bookId, num  from OrderDetail";
		List<OrderDetail> list = new Vector<OrderDetail>();
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(orderDetail);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	public boolean modify(OrderDetail orderDetail) {
		String sql = "update OrderDetail set orderNum = '"+orderDetail.getOrderNum()+"',bookId = '"+orderDetail.getBookId()+"'," +
				" num = '"+orderDetail.getNum()+"' where detail = '"+orderDetail.getDetailId()+"'";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows =    butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public boolean save(OrderDetail orderDetail) {
		String sql = " insert into  orderDetail(orderNum, bookId, num)values('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"'," +
				"'"+orderDetail.getNum()+"') ";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public OrderDetail findByDetailId(int detailId) {
		 String sql = "select detail,orderNum, bookId, num  from OrderDetail where detail = '"+detailId+"'";
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			OrderDetail orderDetail  = null;
			try {
				while (rs.next()) {
					orderDetail = new OrderDetail(rs.getInt(1),
							rs.getString(2), rs.getInt(3), rs.getInt(4));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orderDetail; 
		
	}

	public List<OrderDetail> getnowPageDate(int pageSize, int nowPage) {
		String sql = " select  top "+ pageSize+" detail,orderNum, bookId, num from OrderDetail " +
				"  where detail not in(select top "+ (nowPage-1)*pageSize +" " +
						" detail from OrderDetail )";
		List<OrderDetail> list = new Vector<OrderDetail>();
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(orderDetail);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	
	}

	public int getpageCount(int pageSize) {
    int rowCount = 0;
    int pageCount = 0;
    String sql = "select count(*) detail from OrderDetail ";
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
    pageCount = rowCount/pageSize;
    if ((rowCount%pageSize)!=0) {
		pageCount++;
	}
		return pageCount;
	}

	public boolean save(List<OrderDetail> orderDetails) {
		DButil butil = new DButil();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				butil.update(sql);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean save(Connection connew, List<OrderDetail> orderDetails) {
		DButil butil = new DButil();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				butil.update(connew,sql);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	



}
