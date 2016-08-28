package com.po;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * New entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "new", schema = "dbo", catalog = "yun4jbook")
public class New implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private SysAdmin sysAdmin;
	private String title;
	private String context;
	private Date fbTime;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public New() {
	}

	/** full constructor */
	public New(SysAdmin sysAdmin, String title, String context,
			Date fbTime, Boolean isDelete) {
		this.sysAdmin = sysAdmin;
		this.title = title;
		this.context = context;
		this.fbTime = fbTime;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "newsId", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false)
	public SysAdmin getSysAdmin() {
		return this.sysAdmin;
	}

	public void setSysAdmin(SysAdmin sysAdmin) {
		this.sysAdmin = sysAdmin;
	}

	@Column(name = "title", nullable = false, length = 25)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "context", nullable = false, length = 40)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "FbTime", nullable = false, length = 23)
	public Date getFbTime() {
		return this.fbTime;
	}

	public void setFbTime(Date fbTime) {
		this.fbTime = fbTime;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}