package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import tool.DateConvernt;

import dao.IBookInforDAO;
import dbutil.DButil;
import enetiy.BookInfo;
import enetiy.BookType;

public class BookInfoDAOimpl implements IBookInforDAO{

	public boolean delete(int bookId) {
		boolean flag = false;
		String sql = " update bookInfo set bookStates = 2 from bookinfo where bookId ='"+bookId+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public List<BookInfo> findAll() {
		String sql = "select * from  bookInfo where bookStates = 1 ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<BookInfo> books = new Vector<BookInfo>();
		
		try {
			while (rs.next()) {
				BookInfo type = new BookInfo(rs.getInt(1), 
						rs.getString(2),
						rs.getInt(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9),
						rs.getDate(10), 
						rs.getInt(11),
						rs.getInt(12), 
						rs.getDate(13),
						rs.getInt(14),
						rs.getInt(15));
				books.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return books;
      }

	public boolean modify(BookInfo bookInfo) {
		boolean flag = false;
		int bookStates = 1;
		String btdStr = DateConvernt.ConvertToString(bookInfo.getDatetime());
		String sql = "update  bookInfo set bookName ='"+bookInfo.getBookName()+"'," +
				"booktypeId='"+bookInfo.getBookTypeId()+"'," +
						"author='"+bookInfo.getAuthor()+"'," +
						"pbName='"+bookInfo.getPbName()+"'," +
						"context='"+bookInfo.getContext()+"'," +
					    "smallImg='"+bookInfo.getSmallImg()+"'," +
					    "bigImg ='"+bookInfo.getBigImg()+"'," +
					    "price ='"+bookInfo.getPrice()+"'," +
					    "pbdate='"+btdStr+"'," +
					    "hyprice = '"+bookInfo.getHyprice()+"', " +
					    "bookStates='"+bookStates+"'," +
					    "sjdate='"+btdStr+"'," +
					    "num='"+bookInfo.getNum()+"'," +
					    "saleCount='"+bookInfo.getSaleCount()+"' where bookId = '"+bookInfo.getBookId()+"'";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}
	public boolean save(BookInfo bookInfo) {
		boolean flag = false;
		int bookStates = 1;
		String btdStr = DateConvernt.ConvertToString(bookInfo.getDatetime());
		String sql = "insert into bookInfo(bookName," +
				"booktypeId,author,pbName,context," +
				" smallImg,bigImg,price,pbdate,hyprice," +
				" bookStates,sjdate,num,saleCount)" +
				"values('"+bookInfo.getBookName()+"'," +
				"'"+bookInfo.getBookTypeId()+"'," +
				"'"+bookInfo.getAuthor()+"'," +
				"'"+bookInfo.getPbName()+"'," +
				"'"+bookInfo.getContext()+"'," +
				"'"+bookInfo.getSmallImg()+"'," +
				"'"+bookInfo.getBigImg()+"'," +
				"'"+bookInfo.getPrice()+"'," +
				"'"+btdStr+"'," +
				"'"+bookInfo.getHyprice()+"'," +
				"'"+bookStates+"'," +
				"'"+btdStr+"'," +
				"'"+bookInfo.getNum()+"'," +
			   "'"+bookInfo.getSaleCount()+"')";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}
	

	public BookInfo findById(int bookId) {
		//查找属于所诗歌类别底下的，所有图书
			String sql = "select * from  bookInfo where bookStates = 1 and bookId ="+bookId;
			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			BookInfo type = null;
			try {
				while (rs.next()) {
					       type = new BookInfo(rs.getInt(1), 
									rs.getString(2),
									rs.getInt(3), 
									rs.getString(4),
									rs.getString(5), 
									rs.getString(6),
									rs.getString(7),
									rs.getString(8), 
									rs.getInt(9),
									rs.getDate(10), 
									rs.getInt(11),
									rs.getInt(12), 
									rs.getDate(13),
									rs.getInt(14),
									rs.getInt(15)); 
							
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return type;
		}

	public List<BookInfo> getnowPageData(int pageSize, int nowPage) {
		String sql ="select top " + pageSize + " bookId, bookName,booktypeId,author,pbName,context," +
				" smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate,num,saleCount from" +
				"  BookInfo  where bookStates = 1 and   bookId not in " +
				" ( select  top " +(nowPage-1)*pageSize + " bookId  from BookInfo where bookStates = 1 )";
			DButil butil = new DButil();
			System.out.println(sql);
			ResultSet rs = butil.query(sql);
			List<BookInfo> list = new Vector<BookInfo>();
			try {
				while (rs.next()) {
					BookInfo type = new BookInfo(rs.getInt(1), 
							rs.getString(2),
							rs.getInt(3), 
							rs.getString(4),
							rs.getString(5), 
							rs.getString(6),
							rs.getString(7),
							rs.getString(8), 
							rs.getInt(9),
							rs.getDate(10), 
							rs.getInt(11),
							rs.getInt(12), 
							rs.getDate(13),
							rs.getInt(14),
							rs.getInt(15));
					list.add(type);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				butil.close();
			}
			return list;
	      }

	public int getpageCount(int pageSize) {
		 int pageCount = 0;
	       int rowCount = 0;
	       String sql = "select count(*) bookId from BookInfo  where bookStates = 1";
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

	public List<BookInfo> findBySjDate(int rows) {
		String sql ="select top "  + rows +  " bookId, bookName,booktypeId,author,pbName,context, smallImg,bigImg,price,pbdate," +
				" hyprice,bookStates,sjdate,num,saleCount from bookINfo " +
				" where bookStates = 1 order by  sjdate desc ";
	DButil butil = new DButil();
	System.out.println(sql);
	ResultSet rs = butil.query(sql);
	List<BookInfo> list = new Vector<BookInfo>();
	try {
		while (rs.next()) {
			BookInfo type = new BookInfo(rs.getInt(1), 
					rs.getString(2),
					rs.getInt(3), 
					rs.getString(4),
					rs.getString(5), 
					rs.getString(6),
					rs.getString(7),
					rs.getString(8), 
					rs.getInt(9),
					rs.getDate(10), 
					rs.getInt(11),
					rs.getInt(12), 
					rs.getDate(13),
					rs.getInt(14),
					rs.getInt(15));
			list.add(type);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		butil.close();
	}
	return list;
	}

	public List<BookInfo> findBySaleCount(int rows) {
		String sql =" select top "  + rows +  " bookId, bookName,booktypeId,author,pbName,context, smallImg,bigImg,price,pbdate," +
		" hyprice,bookStates,sjdate,num,saleCount from bookINfo " +
		" where bookStates = 1 order by  saleCount desc ";
DButil butil = new DButil();
System.out.println(sql);
ResultSet rs = butil.query(sql);
List<BookInfo> list = new Vector<BookInfo>();
try {
while (rs.next()) {
	BookInfo type = new BookInfo(rs.getInt(1), 
			rs.getString(2),
			rs.getInt(3), 
			rs.getString(4),
			rs.getString(5), 
			rs.getString(6),
			rs.getString(7),
			rs.getString(8), 
			rs.getInt(9),
			rs.getDate(10), 
			rs.getInt(11),
			rs.getInt(12), 
			rs.getDate(13),
			rs.getInt(14),
			rs.getInt(15));
	list.add(type);
}
} catch (SQLException e) {
e.printStackTrace();
}finally{
butil.close();
}
return list;
	
		
		
		

	}

	public List<BookInfo> findBybookType(int typeId) {
		String sql = "select * from  bookInfo where bookStates = 1 and booktypeId ="+typeId ;
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<BookInfo> books = new Vector<BookInfo>();
		
		try {
			while (rs.next()) {
				BookInfo type = new BookInfo(rs.getInt(1), 
						rs.getString(2),
						rs.getInt(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9),
						rs.getDate(10), 
						rs.getInt(11),
						rs.getInt(12), 
						rs.getDate(13),
						rs.getInt(14),
						rs.getInt(15));
				books.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return books;
      }

	public List<BookInfo> getnowPageData2(int pageSize, int nowPage,
			int bookTypeId) {
		String sql ="select top " + pageSize + " bookId, bookName,booktypeId,author,pbName,context," +
		" smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate,num,saleCount from" +
		"  BookInfo  where bookStates = 1 and   bookTypeId = '"+bookTypeId+"' and bookId not in " +
		" ( select  top " +(nowPage-1)*pageSize + " bookId  from BookInfo where bookStates = 1 and bookTypeId = '"+bookTypeId+"')";
	DButil butil = new DButil();
	System.out.println(sql);
	ResultSet rs = butil.query(sql);
	List<BookInfo> list = new Vector<BookInfo>();
	try {
		while (rs.next()) {
			BookInfo type = new BookInfo(rs.getInt(1), 
					rs.getString(2),
					rs.getInt(3), 
					rs.getString(4),
					rs.getString(5), 
					rs.getString(6),
					rs.getString(7),
					rs.getString(8), 
					rs.getInt(9),
					rs.getDate(10), 
					rs.getInt(11),
					rs.getInt(12), 
					rs.getDate(13),
					rs.getInt(14),
					rs.getInt(15));
			list.add(type);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		butil.close();
	}
	return list;
  }

	public int getpageCount2(int pageSize, int bookTypeId) {
		 int pageCount = 0;
	       int rowCount = 0;
	       String sql = "select count(*) from BookInfo  where bookStates = 1 and bookTypeId = '"+bookTypeId+"'";
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

	}





