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
 * BookDiscuss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bookDiscuss", schema = "dbo", catalog = "yun4jbook")
public class BookDiscuss implements java.io.Serializable {

	// Fields

	private Integer disId;
	private CustomerInfo customerInfo;
	private BookInfo bookInfo;
	private String context;
	private String states;

	// Constructors

	/** default constructor */
	public BookDiscuss() {
	}

	/** minimal constructor */
	public BookDiscuss(String context, String states) {
		this.context = context;
		this.states = states;
	}

	/** full constructor */
	public BookDiscuss(CustomerInfo customerInfo, BookInfo bookInfo,
			String context, String states) {
		this.customerInfo = customerInfo;
		this.bookInfo = bookInfo;
		this.context = context;
		this.states = states;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "disId", unique = true, nullable = false)
	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custId")
	public CustomerInfo getCustomerInfo() {
		return this.customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId")
	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Column(name = "context", nullable = false, length = 100)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "states", nullable = false, length = 20)
	public String getStates() {
		return this.states;
	}

	public void setStates(String states) {
		this.states = states;
	}

}