package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.BookDiscussDAO;
import dbutil.DButil;
import enetiy.BookDiscuss;
import enetiy.OrderDetail;

public class BookDiscussDAOimpl implements BookDiscussDAO{

	public boolean delete(int disId) {
		String sql = "delete from bookDiscuss where disId = '"+disId+"'";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public List<BookDiscuss> findAll() {
		 String sql = "select * from BookDiscuss";
			List<BookDiscuss> list = new Vector<BookDiscuss>();
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			try {
				while (rs.next()) {
					BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
					list.add(bookDiscuss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
	}

	public List<BookDiscuss>  findById(int bookId) {
		 String sql = "select * from BookDiscuss where bookId = '"+bookId+"' and states = 1 ";
		 List<BookDiscuss> list = new Vector<BookDiscuss>();
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			try {
				while (rs.next()) {
					BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
					list.add(bookDiscuss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
	}

	public boolean modify(BookDiscuss bookDiscuss) {
		boolean flag = false;
		String sql = " update bookDiscuss  set custId = '"+bookDiscuss.getCustId()+"',context = '"+bookDiscuss.getContext()+"',states = '"+bookDiscuss.getStates()+"' where bookId = '"+bookDiscuss.getBookId()+"'";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public boolean save(BookDiscuss bookDiscuss) {
		
		String sql = "insert into bookDiscuss  (bookId,custId,context,states)values('"+bookDiscuss.getBookId()+"','"+bookDiscuss.getCustId()+"','"+bookDiscuss.getContext()+"','"+bookDiscuss.getStates()+"')";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public int getPageCount(int pageSize) {
	int rowCount = 0;
	int pageCount = 0;
	String sql = " select  count(*) bookId   from BookDiscuss";
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

	public List<BookDiscuss> getnowPageDate(int pageSize, int nowPage) {
		 String sql = "select  top " + pageSize+ " disId , bookId,custId,context,states from bookDiscuss where bookId not in (select top " +(nowPage-1)*pageSize + "  bookId from  bookDiscuss )";
			List<BookDiscuss> list = new Vector<BookDiscuss>();
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			try {
				while (rs.next()) {
					BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt(1),
							rs.getInt(2),rs.getInt(3),
							rs.getString(4), 
							rs.getString(5));
					list.add(bookDiscuss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;

	}

	public BookDiscuss findById2(int disId) {
		 String sql = "select * from BookDiscuss where disId = '"+disId+"' and states = 1 ";
		 DButil butil = new DButil();
		 BookDiscuss bookDiscuss = null;
			ResultSet rs = butil.query(sql);
			try {
				while (rs.next()) {
					 bookDiscuss = new BookDiscuss(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return bookDiscuss;
	}

}
