package enetiy;

public class OrderDetail {
	 private int  detailId;
	 private  String orderNum;
	 private int bookId;
	 private int  num;
	 public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String orderNum, int bookId, int num) {
		super();
		this.orderNum = orderNum;
		this.bookId = bookId;
		this.num = num;
	}
	public OrderDetail(int detailId, String orderNum, int bookId, int num) {
		super();
		this.detailId = detailId;
		this.orderNum = orderNum;
		this.bookId = bookId;
		this.num = num;
	}
	
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + detailId;
		result = prime * result + num;
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (bookId != other.bookId)
			return false;
		if (detailId != other.detailId)
			return false;
		if (num != other.num)
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderDetail [bookId=" + bookId + ", detailId=" + detailId
				+ ", num=" + num + ", orderNum=" + orderNum + "]";
	}
	
}
