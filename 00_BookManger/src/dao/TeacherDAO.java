package dao;

import java.util.List;

import enetiy.Student;
import enetiy.Teacher;

public interface TeacherDAO {
	public boolean save (Teacher teacher);
	public boolean delete (int  teaId);
	public boolean modefy (Teacher teacher);
	public Teacher findById (int  teaId);
	//��ҳ��
	public int getpageCount(int pageSize);
	//�õ���ǰҳ������
	public List<Teacher> getnowPageData(int pageSize,int nowPage);
	
	public List<Teacher> findAll ();
	
}
