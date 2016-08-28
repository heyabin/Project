package servert.gwc;

public class GwcItem {
	private int bookId;//图书编号
    private String bookName;//图书名称
    private String smallImg;//图书图片    
	private float price;//价格
	private float hyprice;//会员价
	private int num;//购买数量
	
	public GwcItem() {
		// TODO Auto-generated constructor stub
	}
	
	public GwcItem(String bookName, String smallImg, float price,
			float hyprice, int num) {
		super();
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
	}

	public GwcItem(int bookId, String bookName, String smallImg, float price,
			float hyprice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
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

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getHyprice() {
		return hyprice;
	}

	public void setHyprice(float hyprice) {
		this.hyprice = hyprice;
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
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + Float.floatToIntBits(hyprice);
		result = prime * result + num;
		result = prime * result + Float.floatToIntBits(price);
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
		GwcItem other = (GwcItem) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (Float.floatToIntBits(hyprice) != Float
				.floatToIntBits(other.hyprice))
			return false;
		if (num != other.num)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
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
		return "GwcItem [bookId=" + bookId + ", bookName=" + bookName
				+ ", hyprice=" + hyprice + ", num=" + num + ", price=" + price
				+ ", smallImg=" + smallImg + "]";
	}
	
	
}
