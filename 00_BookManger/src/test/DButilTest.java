package test;

import impl.StudentDAOimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import tool.DateConvernt;

import dao.IStudentDAO;
import dbutil.DButil;
import enetiy.Student;

public class DButilTest {
	public static void main(String[] args) {
		//testUpdate();
		//testQuery();
	}
	public static void testUpdate() {
		
		String sql = "insert into student(stuName, stuAge, stuBtd, " +
				"stuSex, stuTel) values('hhhhf',19,'1997-8-19',17, '097778908')";
		DButil butil = new DButil();
		System.out.println(butil.update(sql));
	}
	public static void testQuery() {
		String sql = "select stuId,stuName, stuAge, stuBtd, stuSex, stuTel,isDelete from student where isdelete = 1";
		DButil butil = new DButil();
		ResultSet rs = butil.query(sql);
		try {
			while (rs.next()) {
				System.out.print(rs.getInt(1)+"  ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getInt(3)+"  ");
				System.out.print(rs.getString(4)+"  ");
				System.out.print(rs.getInt(5)+"  ");
				System.out.println(rs.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
