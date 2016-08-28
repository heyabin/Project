	package dao;

import java.util.List;

import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.Student;

public interface IBookInforDAO {
	public boolean save (BookInfo bookInfo);
	public boolean delete (int bookId);
	public boolean modify ( BookInfo bookInfo);
	public BookInfo findById ( int bookId);
	
	public List<BookInfo> findBybookType (int typeId);
	//��ҳ��
	public int getpageCount(int pageSize);
	public int getpageCount2(int pageSize,int bookTypeId );
	//�õ���ǰҳ������
	public List<BookInfo> getnowPageData(int pageSize,int nowPage);
	public List<BookInfo> getnowPageData2(int pageSize,int nowPage,int bookTypeId);
	//�ϼ����ڻ�ȡ������
	public List<BookInfo> findBySjDate (int rows);
	//������������ȡ������
	public List<BookInfo> findBySaleCount (int rows);
	//������������ȡ�Ƽ���
	public List<BookInfo> findAll();
	
	
	
	
}
