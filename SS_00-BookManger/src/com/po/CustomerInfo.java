package com.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * CustomerInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customerInfo", schema = "dbo", catalog = "yun4jbook")
public class CustomerInfo implements java.io.Serializable {

	// Fields

	private Integer custId;
	private String custName;
	private String pwd;
	private String email;
	private Set<BookDiscuss> bookDiscusses = new HashSet<BookDiscuss>(0);
	private Set<OrderMain> orderMains = new HashSet<OrderMain>(0);
	private Set<Favorite> favorites = new HashSet<Favorite>(0);
	private CustomerDetailInfo customerDetailInfo;

	// Constructors

	/** default constructor */
	public CustomerInfo() {
	}

	/** minimal constructor */
	public CustomerInfo(String custName, String pwd, String email) {
		this.custName = custName;
		this.pwd = pwd;
		this.email = email;
	}

	/** full constructor */
	public CustomerInfo(String custName, String pwd, String email,
			Set<BookDiscuss> bookDiscusses, Set<OrderMain> orderMains,
			Set<Favorite> favorites, CustomerDetailInfo customerDetailInfo) {
		this.custName = custName;
		this.pwd = pwd;
		this.email = email;
		this.bookDiscusses = bookDiscusses;
		this.orderMains = orderMains;
		this.favorites = favorites;
		this.customerDetailInfo = customerDetailInfo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "custId", unique = true, nullable = false)
	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Column(name = "custName", nullable = false, length = 100)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "pwd", nullable = false, length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "email", nullable = false, length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerInfo")
	public Set<BookDiscuss> getBookDiscusses() {
		return this.bookDiscusses;
	}

	public void setBookDiscusses(Set<BookDiscuss> bookDiscusses) {
		this.bookDiscusses = bookDiscusses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerInfo")
	public Set<OrderMain> getOrderMains() {
		return this.orderMains;
	}

	public void setOrderMains(Set<OrderMain> orderMains) {
		this.orderMains = orderMains;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerInfo")
	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customerInfo")
	public CustomerDetailInfo getCustomerDetailInfo() {
		return this.customerDetailInfo;
	}

	public void setCustomerDetailInfo(CustomerDetailInfo customerDetailInfo) {
		this.customerDetailInfo = customerDetailInfo;
	}

}