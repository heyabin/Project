package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.IBookTypeDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.Student;

public class BookTypeDAOimpl implements IBookTypeDAO{

	public boolean delete(int bookTypeId) {
		boolean flag = false;
		String sql = " update bookType set isDelete = 0 where bookTypeId ='"+bookTypeId+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public List<BookType> findAll() {
		String sql = "select * from  bookType where isdelete = 1 ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<BookType> books = new Vector<BookType>();
		try {
			while (rs.next()) {
				BookType type = new BookType(rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3),
						rs.getString(4));
				books.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return books;
      }

	public BookType findById(int bookTypeId) {
		String sql = "select * from  bookType where isdelete = 1 and bookTypeId ='"+bookTypeId+"'";
		System.out.println(sql);
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		BookType type = null;
		try {
			while (rs.next()) {
				       type = new BookType(rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3),
						rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	public boolean modify(BookType bookType) {
		boolean flag = false;
		String sql = " update bookType set parentId = '"+bookType.getParentId()+"'," +
				"bookTypeName = '"+bookType.getBookTypeName()+"',context = '"+bookType.getContext()+"'where bookTypeId = '"+bookType.getBookTypeId()+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public boolean save(BookType bookType) {
		boolean flag = false;
		String sql = "insert into bookType (parentId,bookTypeName,context)values( '"+bookType.getParentId()+"','"+bookType.getBookTypeName()+"'," +
				"'"+bookType.getContext()+"') ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	
	}

	public List<BookType> getnowPageData(int pageSize, int nowPage) {
		String sql =" select top " + pageSize + " bookTypeid,parentId ," +
				" bookTypeName,context from  bookType where isDelete = 1 and   bookTypeId not in" +
				" ( select  top " +(nowPage-1)*pageSize + " bookTypeId  " +
						" from bookType where isDelete = 1  )";

			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			List<BookType> bookType = new Vector<BookType>();
			try {
				while (rs.next()) {
					BookType type = new BookType(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
					bookType.add(type);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				butil.close();
			}
			
			return bookType;
				}

	public int getpageCount(int pageSize) {
		 int pageCount = 0;
	       int rowCount = 0;
	       String sql = "select count(*) bookTypeId from bookType where isDelete = 1";
	       DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			Student type = null;
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
 //得到所有父亲编号的图书类别
	public List<BookType> findByParentId(int parentId) {
		String sql = 
			"select " +
			"	bookTypeId,parentId,bookTypeName,context,isDelete " +
			"from " +
			"	bookType " +
			"where " +
			"	parentId = " + parentId;
		List<BookType> bookTypes = new Vector<BookType>();
		  DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				BookType type = new BookType(rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3),
						rs.getString(4));
				bookTypes.add(type);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			butil.close();
		}
		return bookTypes;
	}

}
