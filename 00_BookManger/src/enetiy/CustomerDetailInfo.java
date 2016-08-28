package enetiy;

public class CustomerDetailInfo {
	private int custId	;//  --	编号
	private String tel	;//, --联系电话
	private String address	;//		地址
	private int sex	;//--	性别
	private int age	;//	--年龄
	private int countMoney;//, --累计消费金额
	private int qq  ;//	--QQ
	public CustomerDetailInfo() {
		// TODO Auto-generated constructor stub
	}
	public CustomerDetailInfo(String tel, String address, int sex, int age,
			int countMoney, int qq) {
		super();
		this.tel = tel;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.countMoney = countMoney;
		this.qq = qq;
	}
	public CustomerDetailInfo(int custId, String tel, String address, int sex,
			int age, int countMoney, int qq) {
		super();
		this.custId = custId;
		this.tel = tel;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.countMoney = countMoney;
		this.qq = qq;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(int countMoney) {
		this.countMoney = countMoney;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + countMoney;
		result = prime * result + custId;
		result = prime * result + qq;
		result = prime * result + sex;
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		CustomerDetailInfo other = (CustomerDetailInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (countMoney != other.countMoney)
			return false;
		if (custId != other.custId)
			return false;
		if (qq != other.qq)
			return false;
		if (sex != other.sex)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerDetailInfo [address=" + address + ", age=" + age
				+ ", countMoney=" + countMoney + ", custId=" + custId + ", qq="
				+ qq + ", sex=" + sex + ", tel=" + tel + "]";
	}
	
}
