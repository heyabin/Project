package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.xml.crypto.Data;

import tool.DateConvernt;

import dao.NewDAO;
import dbutil.DButil;
import enetiy.News;
import enetiy.Student;

public class NewDAOimpl implements NewDAO{

	public boolean delete(int newsId) {
		boolean flag = false;;
        String sql = "update new set isDelete = 0 where newsId ='"+newsId+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}
      
	public News find(int newsId) {
        String sql = "select * from new where isDelete = 1 and newsId ='"+newsId+"'";
        DButil butil = new DButil();
         ResultSet  rs=  butil.query(sql);
         News new1 = null;
         try {
 			while (rs.next()) {
 				new1 = new News(rs.getInt(1),rs.getInt(2) , rs.getString(3), rs.getString(4), rs.getDate(5));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return new1 ;
	}

	public List<News> findAll() {
		 String sql = "select * from new ";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<News>list = new Vector<News>(); 
	         try {
	 			while (rs.next()) {
	 				News new1 = new News(rs.getInt(1),rs.getInt(2) , rs.getString(3), rs.getString(4), rs.getDate(5));
	 			     list.add(new1);
	 			} 
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}

	public boolean save(News new1) {
		boolean flag = false;
		String btdStr = DateConvernt.ConvertToString(new1.getFbTime());
        String sql = "insert into new( adminId,title,context,fbTime) values(" +
        		"'"+new1.getAdminId()+"','"+new1.getTitle()+"','"+new1.getContext()+"','"+btdStr+"')";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public boolean update(News new1) {
		boolean flag = false;
		String btdStr = DateConvernt.ConvertToString(new1.getFbTime());
        String sql = "update new set  adminId = '"+new1.getAdminId()+"'," +
        		"title = '"+new1.getTitle()+"'," +
        				"context = '"+new1.getContext()+"',FbTime = '"+btdStr+"' where newsId = '"+new1.getNewsId()+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public List<News> getnowPageData(int nowPage, int pageSize) {
		String sql = " select  top " + pageSize + " newsId,adminId,title,context,FbTime from new " +
				" where isdelete = 1 and newsId not in " +
				"(select top " +(nowPage-1)*pageSize + " newsId  from new where isdelete = 1)";
       DButil butil = new DButil();
         ResultSet  rs=  butil.query(sql);
         List<News>list = new Vector<News>(); 
     try {
		while (rs.next()) {
			News new1 = new News(rs.getInt(1),rs.getInt(2) , rs.getString(3), rs.getString(4),rs.getDate(5));
		     list.add(new1);
		} 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 return list ;
}
	public int getpageCount(int pageSize) {
		 int pageCount = 0;
	     int rowCount = 0;
	       String sql = "select count(*) newsId from new where isDelete = 1";
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
				pageCount ++;
			}
			return pageCount;
	}

	public List<News> findFbTime(int rows) {
		String sql = " select  top " + rows + " newsId,adminId,title,context,FbTime " +
				" from new  where isdelete = 1 order by FbTime desc ";
        DButil butil = new DButil();
         ResultSet  rs=  butil.query(sql);
         List<News>list = new Vector<News>(); 
         try {
 			while (rs.next()) {
 				News new1 = new News(rs.getInt(1),rs.getInt(2) , rs.getString(3), rs.getString(4), rs.getDate(5));
 			     list.add(new1);
 			} 
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return list ;
	}
}
