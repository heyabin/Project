package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.CustomerDetailInfoDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.CustomerDetailInfo;
import enetiy.CustomerInfo;
import enetiy.Student;

public class CustomerDetailInfoDAOimpl implements CustomerDetailInfoDAO{

	public boolean delete(int custId) {
		boolean flag = false;
		String sql = " update CustomerDetailInfo set isDelete = 0 where custId ='"+custId+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}
	public List<CustomerDetailInfo> findAll() {
		String sql = "select * from  customerDetailInfo where isDelete = 1 ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<CustomerDetailInfo> customerDetailInfos = new Vector<CustomerDetailInfo>();
		try {
			while (rs.next()) {
				CustomerDetailInfo type = new CustomerDetailInfo(rs.getInt(1),
						rs.getString(2), rs.getString(3), 
						rs.getInt(4),rs.getInt(5),
						rs.getInt(6),rs.getInt(6));
				customerDetailInfos.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		return customerDetailInfos;
	}

	public CustomerDetailInfo findById(int custId) {
		String sql = "select * from  customerDetailInfo where  custId ='"+custId+"' and isDelete  = 1";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		CustomerDetailInfo type = null;
		try {
			while (rs.next()) {
				       type = new CustomerDetailInfo(rs.getInt(1),
								rs.getString(2), rs.getString(3), 
								rs.getInt(4),rs.getInt(5),
								rs.getInt(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	public boolean modify(CustomerDetailInfo customerDetailInfo) {
		boolean flag = false;
		String sql = " update customerDetailInfo set tel  = '"+customerDetailInfo.getTel()+"'," +
				"address  = '"+customerDetailInfo.getAddress()+"'," +
						"sex = '"+customerDetailInfo.getSex()+"'," +
								"age= '"+customerDetailInfo.getAge()+"'," +
										"countMoney = '"+customerDetailInfo.getCountMoney()+"'," +
												"qq='"+customerDetailInfo.getQq()+"' " +
														"where custId ='"+customerDetailInfo.getCustId()+"'";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>=0) {
		   flag =true;
		}
		return  flag;
	}
	public boolean save(CustomerDetailInfo customerDetailInfo) {
		boolean flag = false;
		String sql = "insert into customerDetailInfo (custId,tel,address,sex,age,countMoney,qq) values ('"+customerDetailInfo.getCustId()+"','"+customerDetailInfo.getTel()+"','"+customerDetailInfo.getAddress()+"','"+customerDetailInfo.getSex()+"'," +
										"'"+customerDetailInfo.getAge()+"','"+customerDetailInfo.getCountMoney()+"','"+customerDetailInfo.getQq()+"') ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}
	public List<CustomerDetailInfo> getnowPageData(int pageSize, int nowPage) {
		String sql =" select top " + pageSize + "custId,tel,address,sex,age,countMoney,qq from  CustomerDetailInfo where isDelete = 1 and   custId not in" +
				" ( select  top " +(nowPage-1)*pageSize + " custId  " +
						" from CustomerDetailInfo where isDelete = 1  )";

			DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			List<CustomerDetailInfo> bookType = new Vector<CustomerDetailInfo>();
			try {
				while (rs.next()) {
					CustomerDetailInfo type = new CustomerDetailInfo(rs.getInt(1),
							rs.getString(2), rs.getString(3), 
							rs.getInt(4),rs.getInt(5),
							rs.getInt(6),rs.getInt(6));
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
	       String sql = "select count(*) custId from CustomerDetailInfo where isDelete = 1";
	       DButil butil = new DButil();
			ResultSet rs = butil.query(sql);
			CustomerDetailInfo type = null;
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
