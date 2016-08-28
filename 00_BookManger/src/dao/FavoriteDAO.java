package dao;

import java.util.List;

import enetiy.Favorite;


public interface FavoriteDAO {
	public boolean save (Favorite favorite);
	public boolean delete (int bookId);
	public boolean modify ( Favorite favorite);
	public Favorite findById ( int favoriteId);
	
	public int getnowPage ( int pageSize);
	public List<Favorite> getnowPageDate (int pageSize,int nowPage);
	public List<Favorite> findAll ();
}
