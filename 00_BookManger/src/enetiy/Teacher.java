package enetiy;

import java.util.Date;

public class Teacher {
	private int teaId;
	private String teaName;
	private int teaAge;
	private Date teaBtd;
	private boolean teaSex;
	private String teaTel;
	private String teaaddress;
 
   public Teacher() {
	// TODO Auto-generated constructor stub
   }

public Teacher(String teaName, int teaAge, Date teaBtd, boolean teaSex,
		String teaTel, String teaaddress) {
	super();
	this.teaName = teaName;
	this.teaAge = teaAge;
	this.teaBtd = teaBtd;
	this.teaSex = teaSex;
	this.teaTel = teaTel;
	this.teaaddress = teaaddress;
}

public Teacher(int teaId, String teaName, int teaAge, Date teaBtd,
		boolean teaSex, String teaTel, String teaaddress) {
	super();
	this.teaId = teaId;
	this.teaName = teaName;
	this.teaAge = teaAge;
	this.teaBtd = teaBtd;
	this.teaSex = teaSex;
	this.teaTel = teaTel;
	this.teaaddress = teaaddress;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + teaAge;
	result = prime * result + ((teaBtd == null) ? 0 : teaBtd.hashCode());
	result = prime * result + teaId;
	result = prime * result + ((teaName == null) ? 0 : teaName.hashCode());
	result = prime * result + (teaSex ? 1231 : 1237);
	result = prime * result + ((teaTel == null) ? 0 : teaTel.hashCode());
	result = prime * result
			+ ((teaaddress == null) ? 0 : teaaddress.hashCode());
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
	Teacher other = (Teacher) obj;
	if (teaAge != other.teaAge)
		return false;
	if (teaBtd == null) {
		if (other.teaBtd != null)
			return false;
	} else if (!teaBtd.equals(other.teaBtd))
		return false;
	if (teaId != other.teaId)
		return false;
	if (teaName == null) {
		if (other.teaName != null)
			return false;
	} else if (!teaName.equals(other.teaName))
		return false;
	if (teaSex != other.teaSex)
		return false;
	if (teaTel == null) {
		if (other.teaTel != null)
			return false;
	} else if (!teaTel.equals(other.teaTel))
		return false;
	if (teaaddress == null) {
		if (other.teaaddress != null)
			return false;
	} else if (!teaaddress.equals(other.teaaddress))
		return false;
	return true;
}

public int getTeaId() {
	return teaId;
}

public void setTeaId(int teaId) {
	this.teaId = teaId;
}

public String getTeaName() {
	return teaName;
}

public void setTeaName(String teaName) {
	this.teaName = teaName;
}

public int getTeaAge() {
	return teaAge;
}

public void setTeaAge(int teaAge) {
	this.teaAge = teaAge;
}

public Date getTeaBtd() {
	return teaBtd;
}

public void setTeaBtd(Date teaBtd) {
	this.teaBtd = teaBtd;
}

public boolean isTeaSex() {
	return teaSex;
}

public void setTeaSex(boolean teaSex) {
	this.teaSex = teaSex;
}

public String getTeaTel() {
	return teaTel;
}

public void setTeaTel(String teaTel) {
	this.teaTel = teaTel;
}

public String getTeaaddress() {
	return teaaddress;
}

public void setTeaaddress(String teaaddress) {
	this.teaaddress = teaaddress;
}

@Override
public String toString() {
	return "Teacher [teaAge=" + teaAge + ", teaBtd=" + teaBtd + ", teaId="
			+ teaId + ", teaName=" + teaName + ", teaSex=" + teaSex
			+ ", teaTel=" + teaTel + ", teaaddress=" + teaaddress + "]";
}
   
   
	
}
