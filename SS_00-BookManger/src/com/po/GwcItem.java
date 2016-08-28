package com.po;

import javax.persistence.Transient;


public class GwcItem {
	private int bookId;//ͼ����
    private String bookName;//ͼ������
    private String smallImg;//ͼ��ͼƬ    
	private Double price;//�۸�
	private Double hyprice;//��Ա��
	private int num;//��������
	public GwcItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GwcItem(String bookName, String smallImg, Double price,
			Double hyprice, int num) {
		super();
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
	}
	public GwcItem(int bookId, String bookName, String smallImg, Double price,
			Double hyprice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
	}
	@Transient
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Transient
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Transient
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	@Transient
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Transient
	public Double getHyprice() {
		return hyprice;
	}
	public void setHyprice(Double hyprice) {
		this.hyprice = hyprice;
	}
	@Transient
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
