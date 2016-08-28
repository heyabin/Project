package dao;

import java.util.List;

import enetiy.Homework;



public interface HomeworkDAO {
	public  boolean save(Homework homework );
	public  boolean delete(int homeId);
	public  boolean update(Homework homework);
	public  List<Homework> find(String homeName);
	public int getpageCount(int pageSize);
	public  List<Homework>  getnowPageData(int nowPage,int pageSize);
	public  List<Homework> findAll();
}
