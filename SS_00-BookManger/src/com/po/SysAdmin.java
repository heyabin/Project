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
import javax.persistence.Table;

/**
 * SysAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysAdmin", schema = "dbo", catalog = "yun4jbook")
public class SysAdmin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String pwd;
	private Integer adminType;
	private Set<OrderMain> orderMains = new HashSet<OrderMain>(0);
	private Set<New> news = new HashSet<New>(0);

	// Constructors

	/** default constructor */
	public SysAdmin() {
	}

	/** minimal constructor */
	public SysAdmin(Integer adminType) {
		this.adminType = adminType;
	}

	/** full constructor */
	public SysAdmin(String adminName, String pwd, Integer adminType,
			Set<OrderMain> orderMains, Set<New> news) {
		this.adminName = adminName;
		this.pwd = pwd;
		this.adminType = adminType;
		this.orderMains = orderMains;
		this.news = news;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "adminId", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "adminName", length = 20)
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "pwd", length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "adminType", nullable = false)
	public Integer getAdminType() {
		return this.adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysAdmin")
	public Set<OrderMain> getOrderMains() {
		return this.orderMains;
	}

	public void setOrderMains(Set<OrderMain> orderMains) {
		this.orderMains = orderMains;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysAdmin")
	public Set<New> getNews() {
		return this.news;
	}

	public void setNews(Set<New> news) {
		this.news = news;
	}

}