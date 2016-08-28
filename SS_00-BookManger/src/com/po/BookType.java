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
 * BookType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bookType", schema = "dbo", catalog = "yun4jbook")
public class BookType implements java.io.Serializable {

	// Fields

	private Integer bookTypeId;
	private Integer parentId;
	private String bookTypeName;
	private String context;
	private Integer isDelete;
	private Set<BookInfo> bookInfos = new HashSet<BookInfo>(0);

	// Constructors

	/** default constructor */
	public BookType() {
	}

	/** minimal constructor */
	public BookType(Integer parentId, String bookTypeName, Integer isDelete) {
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public BookType(Integer parentId, String bookTypeName, String context,
			Integer isDelete, Set<BookInfo> bookInfos) {
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
		this.isDelete = isDelete;
		this.bookInfos = bookInfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bookTypeId", unique = true, nullable = false)
	public Integer getBookTypeId() {
		return this.bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	@Column(name = "parentId", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "bookTypeName", nullable = false, length = 20)
	public String getBookTypeName() {
		return this.bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	@Column(name = "context", length = 40)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "isDelete", nullable = false)
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookType")
	public Set<BookInfo> getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

}