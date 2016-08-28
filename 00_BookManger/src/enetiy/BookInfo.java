package enetiy;

import java.util.Date;

import javax.swing.ImageIcon;

public class BookInfo {
	 private int bookId	;       //	--图书编号
	 private  String bookName ; //--	图书名称
	 private int bookTypeId		; // --图书类别编号
	 private  String author	;     //--	作者
	 private  String pbName	;     //--	出版社名称
	 private  String context	; //--图书介绍
	 private  String smallImg 	; //--图书图片
	 private   String bigImg	; //--图书图片
	 private int  price		; //--	价格
	 private Date	pbdate	; //	出版日期
	 private int hyprice	; //--	会员价
	 private int bookStates		; //--	图书状态 0不可用  1未上架  2上架  3 缺货
	 private Date datetime  ; //上架日期
	 private int num	; //--	库存量
	 private int saleCount	; //	--累积销售量
	
	 public BookInfo() {
		// TODO Auto-generated constructor stub
	}

	public BookInfo(String bookName, int bookTypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			int price, Date pbdate, int hyprice, int bookStates, Date datetime,
			int num, int saleCount) {
		super();
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.datetime = datetime;
		this.num = num;
		this.saleCount = saleCount;
	}

	public BookInfo(int bookId, String bookName, int bookTypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			int price, Date pbdate, int hyprice, int bookStates, Date datetime,
			int num, int saleCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.datetime = datetime;
		this.num = num;
		this.saleCount = saleCount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPbdate() {
		return pbdate;
	}

	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}

	public int getHyprice() {
		return hyprice;
	}

	public void setHyprice(int hyprice) {
		this.hyprice = hyprice;
	}

	public int getBookStates() {
		return bookStates;
	}

	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + bookTypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result
				+ ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + hyprice;
		result = prime * result + num;
		result = prime * result + ((pbName == null) ? 0 : pbName.hashCode());
		result = prime * result + ((pbdate == null) ? 0 : pbdate.hashCode());
		result = prime * result + price;
		result = prime * result + saleCount;
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (hyprice != other.hyprice)
			return false;
		if (num != other.num)
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (pbdate == null) {
			if (other.pbdate != null)
				return false;
		} else if (!pbdate.equals(other.pbdate))
			return false;
		if (price != other.price)
			return false;
		if (saleCount != other.saleCount)
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookInfo [author=" + author + ", bigImg=" + bigImg
				+ ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookStates=" + bookStates + ", bookTypeId=" + bookTypeId
				+ ", context=" + context + ", datetime=" + datetime
				+ ", hyprice=" + hyprice + ", num=" + num + ", pbName="
				+ pbName + ", pbdate=" + pbdate + ", price=" + price
				+ ", saleCount=" + saleCount + ", smallImg=" + smallImg + "]";
	}
	 
	
	 
}
