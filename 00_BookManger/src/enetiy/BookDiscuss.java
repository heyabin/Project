package enetiy;

public class BookDiscuss {
	  private int disId ;// int identity primary key,
	  private int  bookId  ;//  not null,
	  private int  custId ;//int not null,
	  private String  context ;//varchar(12) not null,
	  private String   states ;//varchar(12) not null
    
	  public BookDiscuss() {
	 // TODO Auto-generated constructor stub
     }
	  public BookDiscuss(int disId, int bookId, int custId, String context,
			String states) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.custId = custId;
		this.context = context;
		this.states = states;
	 }

	public BookDiscuss(int bookId, int custId, String context, String states) {
		super();
		this.bookId = bookId;
		this.custId = custId;
		this.context = context;
		this.states = states;
	}

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + custId;
		result = prime * result + disId;
		result = prime * result + ((states == null) ? 0 : states.hashCode());
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
		BookDiscuss other = (BookDiscuss) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (custId != other.custId)
			return false;
		if (disId != other.disId)
			return false;
		if (states == null) {
			if (other.states != null)
				return false;
		} else if (!states.equals(other.states))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookDiscuss [bookId=" + bookId + ", context=" + context
				+ ", custId=" + custId + ", disId=" + disId + ", states="
				+ states + "]";
	}
	  
}
