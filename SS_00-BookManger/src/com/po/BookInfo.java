package com.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bookInfo", schema = "dbo", catalog = "yun4jbook")
public class BookInfo implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private BookType bookType;
	private String bookName;
	private String author;
	private String pbName;
	private String context;
	private String smallImg;
	private String bigImg;
	private Double price;
	private Timestamp pbdate;
	private Double hyprice;
	private Integer bookStates;
	private Timestamp sjdate;
	private Integer num;
	private Integer saleCount;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<Favorite> favorites = new HashSet<Favorite>(0);
	private Set<BookDiscuss> bookDiscusses = new HashSet<BookDiscuss>(0);

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(BookType bookType, String bookName, String author,
			String pbName, String context, String smallImg, String bigImg,
			Double price, Timestamp pbdate, Double hyprice, Integer bookStates,
			Integer num, Integer saleCount) {
		this.bookType = bookType;
		this.bookName = bookName;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.num = num;
		this.saleCount = saleCount;
	}

	/** full constructor */
	public BookInfo(BookType bookType, String bookName, String author,
			String pbName, String context, String smallImg, String bigImg,
			Double price, Timestamp pbdate, Double hyprice, Integer bookStates,
			Timestamp sjdate, Integer num, Integer saleCount,
			Set<OrderDetail> orderDetails, Set<Favorite> favorites,
			Set<BookDiscuss> bookDiscusses) {
		this.bookType = bookType;
		this.bookName = bookName;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
		this.orderDetails = orderDetails;
		this.favorites = favorites;
		this.bookDiscusses = bookDiscusses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bookId", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booktypeId", nullable = false)
	public BookType getBookType() {
		return this.bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	@Column(name = "bookName", nullable = false, length = 20)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "author", nullable = false, length = 20)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "pbName", nullable = false, length = 20)
	public String getPbName() {
		return this.pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}

	@Column(name = "context", nullable = false, length = 200)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "smallImg", nullable = false, length = 20)
	public String getSmallImg() {
		return this.smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	@Column(name = "bigImg", nullable = false, length = 20)
	public String getBigImg() {
		return this.bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	@Column(name = "price", nullable = false, scale = 4)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "pbdate", nullable = false, length = 23)
	public Timestamp getPbdate() {
		return this.pbdate;
	}

	public void setPbdate(Timestamp pbdate) {
		this.pbdate = pbdate;
	}

	@Column(name = "hyprice", nullable = false, scale = 4)
	public Double getHyprice() {
		return this.hyprice;
	}

	public void setHyprice(Double hyprice) {
		this.hyprice = hyprice;
	}

	@Column(name = "bookStates", nullable = false)
	public Integer getBookStates() {
		return this.bookStates;
	}

	public void setBookStates(Integer bookStates) {
		this.bookStates = bookStates;
	}

	@Column(name = "sjdate", length = 23)
	public Timestamp getSjdate() {
		return this.sjdate;
	}

	public void setSjdate(Timestamp sjdate) {
		this.sjdate = sjdate;
	}

	@Column(name = "num", nullable = false)
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "saleCount", nullable = false)
	public Integer getSaleCount() {
		return this.saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookInfo")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookInfo")
	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookInfo")
	public Set<BookDiscuss> getBookDiscusses() {
		return this.bookDiscusses;
	}

	public void setBookDiscusses(Set<BookDiscuss> bookDiscusses) {
		this.bookDiscusses = bookDiscusses;
	}

}