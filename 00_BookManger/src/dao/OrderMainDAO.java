package dao;

import java.sql.Connection;
import java.util.List;

import enetiy.OrderMain;

public interface OrderMainDAO {
	public boolean save (OrderMain orderMain);
	public boolean save (Connection newcon ,OrderMain orderMain);
	public boolean delete (String orderNum);
	public boolean modify ( OrderMain orderMain);
	public OrderMain findById (String orderNum);
	public int getpageCount(int pageSize);
    public 	List<OrderMain> getnowPageData(int pageSize,int nowPage);
	public List<OrderMain> findAll ();

}

