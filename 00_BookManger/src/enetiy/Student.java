package enetiy;

import java.util.Date;

public class Student {
	private int stuId;
	private String stuName;
	private int stuAge;
	private Date stuBtd;
	private boolean stuSex;
	private String stuTel;
	private boolean isDelete;

	public Student() {
		super();
	}
	public Student(String stuName, int stuAge, Date stuBtd, boolean stuSex,
			String stuTel) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuBtd = stuBtd;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
	}
	public Student(int stuId, String stuName, int stuAge, Date stuBtd,
			boolean stuSex, String stuTel) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuBtd = stuBtd;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public Date getStuBtd() {
		return stuBtd;
	}
	public void setStuBtd(Date stuBtd) {
		this.stuBtd = stuBtd;
	}
	public boolean isStuSex() {
		return stuSex;
	}
	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	@Override
	public String toString() {
		return "Student [stuAge=" + stuAge + ", stuBtd=" + stuBtd + ", stuId="
				+ stuId + ", stuName=" + stuName + ", stuSex=" + stuSex
				+ ", stuTel=" + stuTel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stuAge;
		result = prime * result + ((stuBtd == null) ? 0 : stuBtd.hashCode());
		result = prime * result + stuId;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		result = prime * result + (stuSex ? 1231 : 1237);
		result = prime * result + ((stuTel == null) ? 0 : stuTel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stuAge != other.stuAge)
			return false;
		if (stuBtd == null) {
			if (other.stuBtd != null)
				return false;
		} else if (!stuBtd.equals(other.stuBtd))
			return false;
		if (stuId != other.stuId)
			return false;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		if (stuSex != other.stuSex)
			return false;
		if (stuTel == null) {
			if (other.stuTel != null)
				return false;
		} else if (!stuTel.equals(other.stuTel))
			return false;
		return true;
	}
}
