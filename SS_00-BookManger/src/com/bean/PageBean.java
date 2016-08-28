package com.bean;

import java.io.Serializable;
import java.util.*;
@SuppressWarnings("serial")
public class PageBean implements Serializable {
	/*
	 * page= nowPage当前页
	 * rows = pageSize; 每页大小
	 * maxpage = 最大页,相当于pageCount;
	 */
	private int page=1;
	private int rows=3;
	private int maxpage;
	private List<?> pagelist;
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int page, int rows, int maxpage, List<?> pagelist) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxpage = maxpage;
		this.pagelist = pagelist;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public List<?> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<?> pagelist) {
		this.pagelist = pagelist;
	}
	
}
