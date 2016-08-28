package enetiy;

import java.util.Date;

public class Favorite {
	 private int favoriteId;
	 private int bookId ;
	 private int custId ;
	 private Date date ;
	 private String context;
	 
	 public Favorite() {
		// TODO Auto-generated constructor stub
	}
	public Favorite(int bookId, int custId, Date date, String context) {
		super();
		this.bookId = bookId;
		this.custId = custId;
		this.date = date;
		this.context = context;
	}
	public Favorite(int favoriteId, int bookId, int custId, Date date,
			String context) {
		super();
		this.favoriteId = favoriteId;
		this.bookId = bookId;
		this.custId = custId;
		this.date = date;
		this.context = context;
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + custId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + favoriteId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (custId != other.custId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (favoriteId != other.favoriteId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Favorite [bookId=" + bookId + ", context=" + context
				+ ", custId=" + custId + ", date=" + date + ", favoriteId="
				+ favoriteId + "]";
	}
	 
}
