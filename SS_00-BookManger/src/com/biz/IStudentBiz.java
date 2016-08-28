package com.biz;

import java.util.List;

import com.po.Student;

public interface IStudentBiz {
	public boolean save (Student student);
	public boolean delById (int  stuId);
	public boolean update (Student student);
	public Student findById (int  stuId);
	public List<Student> findAll ();
	//总页数
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<Student> getnowPageData(int pageSize,int nowPage);
	

}
