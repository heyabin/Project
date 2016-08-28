package dao;

import java.util.List;

import enetiy.Student;
import enetiy.Teacher;

public interface TeacherDAO {
	public boolean save (Teacher teacher);
	public boolean delete (int  teaId);
	public boolean modefy (Teacher teacher);
	public Teacher findById (int  teaId);
	//总页数
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<Teacher> getnowPageData(int pageSize,int nowPage);
	
	public List<Teacher> findAll ();
	
}
