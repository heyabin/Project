package dao;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import enetiy.BookInfo;
import enetiy.News;

public interface NewDAO {
	public  boolean save(News new1);
	public  boolean delete(int newsId);
	public  boolean update(News new1);
	public  News find(int newsId);
	public int getpageCount(int pageSize);
	public  List<News>  getnowPageData(int nowPage,int pageSize);
	public  List<News> findAll();
	public List<News> findFbTime (int rows);
}
