package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;

import dao.IStudentDAO;
import dao.TeacherDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.Student;
import enetiy.Teacher;

public class TeacherDAOimpl implements TeacherDAO{

	

	public List<Teacher> findAll() {
		String sql = "select teaId,teaName, teaAge, teaBtd, teaSex, teaTel,teaaddress from  teacher ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<Teacher> teachers = new Vector<Teacher>();
		try {
			while (rs.next()) {
				Teacher type = new Teacher(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getDate(4), 
						rs.getBoolean(5), 
						rs.getString(6), 
						rs.getString(7));
						
				teachers.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return teachers;
      }


	public Teacher findById(int teaId) {
		String sql = "select teaId,teaName, teaAge, teaBtd, teaSex, teaTel,teaaddress from " +
				" teacher  where  teaId ='"+teaId+"'";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		Teacher type = null;
		try {
			while (rs.next()) {
				       type = new Teacher(rs.getInt(1), rs.getString(2), rs.getInt(3),
								rs.getDate(4), 
								rs.getBoolean(5), 
								rs.getString(6), 
								rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	public boolean modefy(Teacher teacher) {
		boolean flag = false;
		int teaSex = 0;
		if (teacher.isTeaSex())  teaSex = 1;
		String btdStr = DateConvernt.ConvertToString(teacher.getTeaBtd());
		String sql = " update teacher set teaName = '"+teacher.getTeaName()+"',teaAge = '"+teacher.getTeaAge()+"', " +
				" teaBtd ='"+btdStr+"',	 teaSex = '"+teaSex+"',teaTel = '"+teacher.getTeaTel()+"',teaaddress = '"+teacher.getTeaaddress()+"' where teaId = '"+teacher.getTeaId()+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public boolean save(Teacher teacher) {
		boolean flag = false;
		int teaSex = 0;
		if (teacher.isTeaSex())  teaSex = 1;
		//先将日期转换为字符串，测试时再将字符串转换为日期
		String btdStr = DateConvernt.ConvertToString(teacher.getTeaBtd());
		String sql = "insert into teacher (teaName, teaAge, teaBtd, teaSex, teaTel,teaaddress)values( '"+teacher.getTeaName()+"'," +
				"'"+teacher.getTeaAge()+"','"+btdStr+"','"+teaSex+"','"+teacher.getTeaTel()+"','"+teacher.getTeaaddress()+"') ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}


	public boolean delete(int teaId) {
			boolean flag = false;
			String sql = " delete from teacher where teaId = '"+teaId+"'";
			DButil butil = new DButil();
		    int rows = butil.update(sql);
			if (rows>0) {
				flag =true;
			}
			return flag;
		}


	public List<Teacher> getnowPageData(int pageSize, int nowPage) {
		String sql =" select top " + pageSize + " teaId,teaName, teaAge, teaBtd, teaSex, teaTel,teaaddress from teacher  where " +
				" teaId not in ( select  top "+(nowPage - 1)*pageSize +"   teaId   from teacher  )";
      
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<Teacher> teachers = new Vector<Teacher>();
		try {
			while (rs.next()) {
				Teacher type = new Teacher(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getDate(4), 
						rs.getBoolean(5), 
						rs.getString(6), 
						rs.getString(7));
						
				teachers.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return teachers;
      }



	public int getpageCount(int pageSize) {
       int pageCount = 0;
       int rowCount = 0;
       String sql = "select count(*) teaId from teacher ";
       DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		Teacher type = null;
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
