package com.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OrderMain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OrderMain", schema = "dbo", catalog = "yun4jbook")
public class OrderMain implements java.io.Serializable {


	// Fields

	private String orderNum;
	private CustomerInfo customerInfo;
	private String customerName;
	private String tel;
	private String address;
	private char status;
	private SysAdmin sysAdmin;
	private String context;
	private float sumprice;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	// Constructors

	/** default constructor */
	public OrderMain() {
	}

	/** minimal constructor */
	public OrderMain(String orderNum, CustomerInfo customerInfo,
			String customerName, String tel, String address, char status,
			SysAdmin sysAdmin, String context, float sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerInfo = customerInfo;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.sysAdmin = sysAdmin;
		this.context = context;
		this.sumprice = sumprice;
	}

	/** full constructor */

	public OrderMain(String orderNum, CustomerInfo customerInfo,
			String customerName, String tel, String address, char status,
			SysAdmin sysAdmin, String context, float sumprice,
			Set<OrderDetail> orderDetails) {
		super();
		this.orderNum = orderNum;
		this.customerInfo = customerInfo;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.sysAdmin = sysAdmin;
		this.context = context;
		this.sumprice = sumprice;
		this.orderDetails = orderDetails;
	}
	


	// Property accessors
	@Id
	@Column(name = "orderNum", unique = true, nullable = false)
	public String getOrderNum() {
		return this.orderNum;
	}
	
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId")
	public SysAdmin getSysAdmin() {
		return this.sysAdmin;
	}

	public void setSysAdmin(SysAdmin sysAdmin) {
		this.sysAdmin = sysAdmin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	public CustomerInfo getCustomerInfo() {
		return this.customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Column(name = "customerName", length = 20)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "tel", nullable = false, length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "status", length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Column(name = "context", nullable = false, length = 100)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "sumprice", nullable = false, scale = 4)
	public float getSumprice() {
		return this.sumprice;
	}

	public void setSumprice(float sumprice) {
		this.sumprice = sumprice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderMain")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}