package com.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favorite", schema = "dbo", catalog = "yun4jbook")
public class Favorite implements java.io.Serializable {

	// Fields

	private Integer favoriteId;
	private CustomerInfo customerInfo;
	private BookInfo bookInfo;
	private Timestamp date;
	private String context;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** full constructor */
	public Favorite(CustomerInfo customerInfo, BookInfo bookInfo,
			Timestamp date, String context) {
		this.customerInfo = customerInfo;
		this.bookInfo = bookInfo;
		this.date = date;
		this.context = context;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "favoriteId", unique = true, nullable = false)
	public Integer getFavoriteId() {
		return this.favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custId", nullable = false)
	public CustomerInfo getCustomerInfo() {
		return this.customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", nullable = false)
	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Column(name = "date", nullable = false, length = 23)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "context", nullable = false, length = 100)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}