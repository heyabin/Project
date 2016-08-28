package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderDetail", schema = "dbo", catalog = "yun4jbook")
public class OrderDetail implements java.io.Serializable {

	// Fields

	private Integer detail;
	private OrderMain orderMain;
	private BookInfo bookInfo;
	private Integer num;

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(OrderMain orderMain, BookInfo bookInfo, Integer num) {
		this.orderMain = orderMain;
		this.bookInfo = bookInfo;
		this.num = num;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "detail", unique = true, nullable = false)
	public Integer getDetail() {
		return this.detail;
	}

	public void setDetail(Integer detail) {
		this.detail = detail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderNum", nullable = false)
	public OrderMain getOrderMain() {
		return this.orderMain;
	}

	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", nullable = false)
	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Column(name = "num", nullable = false)
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}