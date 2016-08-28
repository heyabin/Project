package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;

import dao.IStudentDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.Student;

public class StudentDAOimpl implements IStudentDAO{

	

	public List<Student> findAll() {
		String sql = "select * from  student where isdelete = 1 ";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<Student> students = new Vector<Student>();
		try {
			while (rs.next()) {
				Student type = new Student(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3), 
						rs.getDate(4), 
						rs.getBoolean(5),
						rs.getString(6));
				students.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return students;
      }


	public Student findById(int stuId) {
		String sql = "select * from  Student where isdelete = 1 and stuId ='"+stuId+"'";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		Student type = null;
		try {
			while (rs.next()) {
				       type = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	public boolean modefy(Student stu) {
		boolean flag = false;
		int stuSex = 0;
		if (stu.isStuSex())  stuSex = 1;
		String btdStr = DateConvernt.ConvertToString(stu.getStuBtd());
		String sql = " update student set stuName = '"+stu.getStuName()+"'," +
				"stuAge = '"+stu.getStuAge()+"'," +
						"stuBtd = '"+btdStr+"'," +
								"stuSex = '"+stuSex+"', " +
										"stuTel = '"+stu.getStuTel()+"'where stuId = '"+stu.getStuId()+"' ";
		DButil butil = new DButil();
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}

	public boolean save(Student student) {
		boolean flag = false;
		int stuSex = 0;
		if (student.isStuSex())  stuSex = 1;
		//先将日期转换为字符串，测试时再将字符串转换为日期
		String btdStr = DateConvernt.ConvertToString(student.getStuBtd());
		String sql = "insert into student (stuName,stuAge,stuBtd,stuSex,stuTel)values( '"+student.getStuName()+"'," +
				"'"+student.getStuAge()+"','"+btdStr+"','"+stuSex+"','"+student.getStuTel()+"') ";
		DButil butil = new DButil();
		System.out.println(sql);
	    int rows = butil.update(sql);
		if (rows>0) {
			flag =true;
		}
		return flag;
	}


	public boolean delete(int stuId) {
			boolean flag = false;
			String sql = " update student set isDelete = 0 where stuId ='"+stuId+"'";
			DButil butil = new DButil();
			System.out.println(sql);
		    int rows = butil.update(sql);
			if (rows>0) {
				flag =true;
			}
			return flag;
		}


	public List<Student> getnowPageData(int pageSize, int nowPage) {
		String sql =" select top " + pageSize + " stuId, stuName, stuAge, stuBtd, stuSex, stuTel from " +
				" student " +
				" where isDelete = 1 and  " +
				" stuId not in ( select  top " +(nowPage-1)*pageSize + " stuId  " +
						" from student where isDelete = 1  )";
      
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		List<Student> students = new Vector<Student>();
		try {
			while (rs.next()) {
				Student type = new Student(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3), 
						rs.getDate(4), 
						rs.getBoolean(5),
						rs.getString(6));
				students.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			butil.close();
		}
		
		return students;
      }



	public int getpageCount(int pageSize) {
       int pageCount = 0;
       int rowCount = 0;
       String sql = "select count(*) stuId from student where isDelete = 1";
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
	
	
}
