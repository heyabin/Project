package com.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", schema = "dbo", catalog = "yun4jbook")
public class Student implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String stuName;
	private Integer stuAge;
	private Timestamp stuBtd;
	private Boolean stuSex;
	private String stuTel;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String stuName, Integer stuAge, Timestamp stuBtd,
			Boolean stuSex, String stuTel, Boolean isDelete) {
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuBtd = stuBtd;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "stuId", unique = true, nullable = false)
	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	@Column(name = "stuName", nullable = false, length = 20)
	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "stuAge", nullable = false)
	public Integer getStuAge() {
		return this.stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	@Column(name = "stuBtd", nullable = false, length = 23)
	public Timestamp getStuBtd() {
		return this.stuBtd;
	}

	public void setStuBtd(Timestamp stuBtd) {
		this.stuBtd = stuBtd;
	}

	@Column(name = "stuSex", nullable = false)
	public Boolean getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(Boolean stuSex) {
		this.stuSex = stuSex;
	}

	@Column(name = "stuTel", nullable = false, length = 11)
	public String getStuTel() {
		return this.stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}