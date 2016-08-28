package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * CustomerDetailInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customerDetailInfo", schema = "dbo", catalog = "yun4jbook")
public class CustomerDetailInfo implements java.io.Serializable {

	// Fields

	private Integer custId;
	private CustomerInfo customerInfo;
	private String tel;
	private String address;
	private Integer sex;
	private Integer age;
	private Double countMoney;
	private Integer qq;

	// Constructors

	/** default constructor */
	public CustomerDetailInfo() {
	}

	/** minimal constructor */
	public CustomerDetailInfo(CustomerInfo customerInfo, String tel, Integer sex) {
		this.customerInfo = customerInfo;
		this.tel = tel;
		this.sex = sex;
	}

	/** full constructor */
	public CustomerDetailInfo(CustomerInfo customerInfo, String tel,
			String address, Integer sex, Integer age, Double countMoney,
			Integer qq) {
		this.customerInfo = customerInfo;
		this.tel = tel;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.countMoney = countMoney;
		this.qq = qq;
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

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public CustomerInfo getCustomerInfo() {
		return this.customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Column(name = "tel", nullable = false, length = 13)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "address", length = 20)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "sex", nullable = false)
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "countMoney", scale = 4)
	public Double getCountMoney() {
		return this.countMoney;
	}

	public void setCountMoney(Double countMoney) {
		this.countMoney = countMoney;
	}

	@Column(name = "qq")
	public Integer getQq() {
		return this.qq;
	}

	public void setQq(Integer qq) {
		this.qq = qq;
	}

}