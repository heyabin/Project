package enetiy;

public class OrderMain {
	 private String orderNum ;//	varchar(20)  ;//primary key, 	  --�������    PK
	 private  int customerId ;//	int      not null,                --�ͻ����    FK
	 private String   customerName;//	varchar(20)           		  --�ջ�������		
	 private String tel	 ;//       varchar(20)  not null,    	  --�ջ��˵绰		
	 private String address	;//	varchar(100)  not null,   	  --�ջ���ַ	
	 private String status	;//	char(1) ,        		  --���۵�״̬��0-δ����1-�Ѵ���2-�Է�����3-���ջ���
	 private int adminId	;//	int  ,   		  --�����˱��  FK
	 private String context	;//	varchar(100) not null,	          --��ע
	 private double sumprice ;//	 money not null                   --�ܼ�
	 private boolean isDelete ;//bit
	 public OrderMain() {
		// TODO Auto-generated constructor stub
	}
	public OrderMain(int customerId, String customerName, String tel,
			String address, String status, int adminId, String context,
			double sumprice) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}
	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address, String status,
			String context, double sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.context = context;
		this.sumprice = sumprice;
	}
	
	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address, String status, int adminId,
			String context, double sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public double getSumprice() {
		return sumprice;
	}
	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "OrderMain [address=" + address + ", adminId=" + adminId
				+ ", context=" + context + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", isDelete=" + isDelete
				+ ", orderNum=" + orderNum + ", status=" + status
				+ ", sumprice=" + sumprice + ", tel=" + tel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + adminId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + customerId;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + (isDelete ? 1231 : 1237);
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sumprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderMain other = (OrderMain) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adminId != other.adminId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(sumprice) != Double
				.doubleToLongBits(other.sumprice))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	
}