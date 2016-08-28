package enetiy;

import java.util.Date;

   public class News {
	 private int  newsId ;// int identity primary key,
	 private int  adminId;//   int not null ,
	 private String title ; // varchar(25) not null,
	 private String context;// varchar(40) not null,
	 private Date fbTime ;// Datetime not null,
     private boolean  isDelete ;// bit not null
  public News() {
	// TODO Auto-generated constructor stub
  }
public News(int adminId, String title, String context, Date fbTime) {
	super();
	this.adminId = adminId;
	this.title = title;
	this.context = context;
	this.fbTime = fbTime;
}
public News(int newsId, int adminId, String title, String context, Date fbTime) {
	super();
	this.newsId = newsId;
	this.adminId = adminId;
	this.title = title;
	this.context = context;
	this.fbTime = fbTime;
}
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public Date getFbTime() {
	return fbTime;
}
public void setFbTime(Date fbTime) {
	this.fbTime = fbTime;
}
public boolean isDelete() {
	return isDelete;
}
public void setDelete(boolean isDelete) {
	this.isDelete = isDelete;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + adminId;
	result = prime * result + ((context == null) ? 0 : context.hashCode());
	result = prime * result + ((fbTime == null) ? 0 : fbTime.hashCode());
	result = prime * result + (isDelete ? 1231 : 1237);
	result = prime * result + newsId;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	News other = (News) obj;
	if (adminId != other.adminId)
		return false;
	if (context == null) {
		if (other.context != null)
			return false;
	} else if (!context.equals(other.context))
		return false;
	if (fbTime == null) {
		if (other.fbTime != null)
			return false;
	} else if (!fbTime.equals(other.fbTime))
		return false;
	if (isDelete != other.isDelete)
		return false;
	if (newsId != other.newsId)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
@Override
public String toString() {
	return "News [adminId=" + adminId + ", context=" + context + ", fbTime="
			+ fbTime + ", isDelete=" + isDelete + ", newsId=" + newsId
			+ ", title=" + title + "]";
}
   
  
  
}
