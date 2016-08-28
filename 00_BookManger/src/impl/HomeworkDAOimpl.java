package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;

import dao.HomeworkDAO;
import dbutil.DButil;
import enetiy.Homework;
import enetiy.News;

public class HomeworkDAOimpl implements HomeworkDAO{

	public boolean delete(int homeId) {
		boolean flag = false;;
        String sql = "delete from homework where homeId = '"+homeId+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public List<Homework> find(String homeName) {
		 String sql = "select homeId ,homeName, homecontext , homesumbmit , homegrade , author from homework where homename ='"+homeName+"'";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<Homework> list = new Vector<Homework>(); 
	         try {
	 			while (rs.next()) {
	 				Homework homewor = new Homework(rs.getInt(1), 
	 						rs.getString(2),
	 						rs.getString(3), 
	 						rs.getDate(4),
	 						rs.getInt(5), rs.getString(6));
	 			     list.add(homewor);
	 			} 
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}

	public List<Homework> findAll() {
		 String sql = "select homeId ,homeName, homecontext , homesumbmit , homegrade , author from homework ";
	        DButil butil = new DButil();
	         ResultSet  rs=  butil.query(sql);
	         List<Homework> list = new Vector<Homework>(); 
	         try {
	 			while (rs.next()) {
	 				Homework homework = new Homework(rs.getInt(1), 
	 						rs.getString(2),
	 						rs.getString(3), 
	 						rs.getDate(4),
	 						rs.getInt(5), rs.getString(6));
	 			     list.add(homework);
	 			} 
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         return list ;
	}

	public List<Homework> getnowPageData(int nowPage, int pageSize) {
		String sql = " select  top " + pageSize + " homeId,homeName, homecontext , homesumbmit , homegrade , author   from homework " +
		" where  homeId not in " +
		"(select top " +(nowPage-1)*pageSize + " homeId  from homework )";
DButil butil = new DButil();
ResultSet  rs=  butil.query(sql);
List<Homework> list = new Vector<Homework>();  
try {
while (rs.next()) {
	Homework homework = new Homework(rs.getInt(1), 
				rs.getString(2),
				rs.getString(3), 
				rs.getDate(4),
				rs.getInt(5), rs.getString(6));
	     list.add(homework);
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
	       String sql = "select count(*) homeId from  homework ";
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

	public boolean save(Homework homework) {
		boolean flag = false;
		String subtime = DateConvernt.ConvertToString(homework.getHomesumbmit());
        String sql = "insert into homework( homeName, homecontext , homesumbmit , homegrade , author) values('"+homework.getHomeName()+"','"+homework.getHomecontext()+"','"+subtime+"','"+homework.getHomegrade()+"','"+homework.getAuthor()+"')";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

	public boolean update(Homework homework) {
		boolean flag = false;
		String subtime = DateConvernt.ConvertToString(homework.getHomesumbmit());
        String sql = "update homework set  homeName = '"+homework.getHomeName()+"'," +
        		"homecontext = '"+homework.getHomecontext()+"'," +
        				"homesumbmit = '"+subtime+"',homegrade = '"+homework.getHomegrade()+"',author = '"+homework.getAuthor()+"' where homeId = '"+homework.getHomeId()+"'";
        DButil butil = new DButil();
         int n =  butil.update(sql);
         if (n>0) {
			flag= true;
		}
		return flag;
	}

}
