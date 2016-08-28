package enetiy;

import java.util.Date;

public class Homework {
	private int homeId;
	private String homeName;
	private String homecontext;
	private Date homesumbmit;
	private int homegrade;
	private String author;
   public Homework() {
	// TODO Auto-generated constructor stub 
   }
public Homework(String homeName, String homecontext, Date homesumbmit,
		int homegrade, String author) {
	super();
	this.homeName = homeName;
	this.homecontext = homecontext;
	this.homesumbmit = homesumbmit;
	this.homegrade = homegrade;
	this.author = author;
}
public Homework(int homeId, String homeName, String homecontext,
		Date homesumbmit, int homegrade, String author) {
	super();
	this.homeId = homeId;
	this.homeName = homeName;
	this.homecontext = homecontext;
	this.homesumbmit = homesumbmit;
	this.homegrade = homegrade;
	this.author = author;
}
public int getHomeId() {
	return homeId;
}
public void setHomeId(int homeId) {
	this.homeId = homeId;
}
public String getHomeName() {
	return homeName;
}
public void setHomeName(String homeName) {
	this.homeName = homeName;
}
public String getHomecontext() {
	return homecontext;
}
public void setHomecontext(String homecontext) {
	this.homecontext = homecontext;
}
public Date getHomesumbmit() {
	return homesumbmit;
}
public void setHomesumbmit(Date homesumbmit) {
	this.homesumbmit = homesumbmit;
}
public int getHomegrade() {
	return homegrade;
}
public void setHomegrade(int homegrade) {
	this.homegrade = homegrade;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + homeId;
	result = prime * result + ((homeName == null) ? 0 : homeName.hashCode());
	result = prime * result
			+ ((homecontext == null) ? 0 : homecontext.hashCode());
	result = prime * result + homegrade;
	result = prime * result
			+ ((homesumbmit == null) ? 0 : homesumbmit.hashCode());
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
	Homework other = (Homework) obj;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (homeId != other.homeId)
		return false;
	if (homeName == null) {
		if (other.homeName != null)
			return false;
	} else if (!homeName.equals(other.homeName))
		return false;
	if (homecontext == null) {
		if (other.homecontext != null)
			return false;
	} else if (!homecontext.equals(other.homecontext))
		return false;
	if (homegrade != other.homegrade)
		return false;
	if (homesumbmit == null) {
		if (other.homesumbmit != null)
			return false;
	} else if (!homesumbmit.equals(other.homesumbmit))
		return false;
	return true;
}
@Override
public String toString() {
	return "Homework [author=" + author + ", homeId=" + homeId + ", homeName="
			+ homeName + ", homecontext=" + homecontext + ", homegrade="
			+ homegrade + ", homesumbmit=" + homesumbmit + "]";
}
   
}
