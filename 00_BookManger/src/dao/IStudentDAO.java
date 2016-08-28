package dao;

import java.util.List;

import enetiy.Student;

public interface IStudentDAO {
	public boolean save (Student student);
	public boolean delete (int  stuId);
	public boolean modefy (Student stu);
	public Student findById (int  stuId);
	//总页数
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<Student> getnowPageData(int pageSize,int nowPage);
	
	public List<Student> findAll ();
	
}
