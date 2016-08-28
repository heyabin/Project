package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;

import dao.FavoriteDAO;
import dbutil.DButil;
import enetiy.BookDiscuss;
import enetiy.Favorite;

public class FavoriteDAOimpl implements FavoriteDAO{

	public boolean delete(int favoriteId) {
		String sql = "delete from  Favorite where favoriteId = '"+favoriteId+"'";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public List<Favorite> findAll() {
		String sql = "select * from Favorite";
		List<Favorite> list = new Vector<Favorite>();
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				Favorite favorite = new Favorite(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5));
				list.add(favorite);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	public Favorite findById(int bookId) {
		 String sql = "select * from Favorite where favoriteId = '"+bookId+"'";
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			Favorite favorite  = null;
			try {
				while (rs.next()) {
					favorite= new Favorite(rs.getInt(1), rs.getInt(2), rs.getInt(3),
							rs.getDate(4), rs.getString(5));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return favorite; 
	}

	public boolean modify(Favorite favorite) {
		boolean flag = false;
		String  btd = DateConvernt.ConvertToString(favorite.getDate());
		String sql = " update Favorite set bookId  = '"+favorite.getBookId()+"',custId = '"+favorite.getCustId()+"',date = '"+btd +"',context = '"+favorite.getContext()+"' where favoriteId= '"+favorite.getFavoriteId()+"'";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public boolean save(Favorite favorite) {
		String btd =  DateConvernt.ConvertToString(favorite.getDate());
		String sql = "insert into Favorite  (bookId,custId,date,context)values('"+favorite.getBookId()+"','"+favorite.getCustId()+"','"+btd+"','"+favorite.getContext()+"')";
		DButil butil = new DButil();
		Boolean flag = false;
		 int rows = butil.update(sql);
		 if (rows>0) {
			flag = true;
		}
		return flag;
	}

	public int getnowPage(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select  count(*) favoriteId   from favorite ";
		DButil butil = new DButil();
		ResultSet rs =    butil.query(sql);
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

	public List<Favorite> getnowPageDate(int pageSize, int nowPage) {
		String sql = " select top " + pageSize + " favoriteId, bookId, custId, date, context from Favorite  where favoriteId not in ( select top "+ (nowPage-1)*pageSize +"	 favoriteId  from Favorite) "; 
		List<Favorite> list = new Vector<Favorite>();
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				Favorite favorite = new Favorite(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5));
				list.add(favorite);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;

	}

}
