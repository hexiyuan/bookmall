package core.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	private String id;
	private Date ordertime;  
	private boolean state; 
	private double price;    
	
	private User user;
	
	private List<OrderItem> orderitems;  

//	private Set orderitems = new HashSet();  
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	//	public Set getOrderitems() {
//		return orderitems;
//	}
//	public void setOrderitems(Set orderitems) {
//		this.orderitems = orderitems;
//	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", ordertime=" + ordertime + ", state=" + state + ", price=" + price + ", user="
				+ user + ", orderitems=" + orderitems + "]";
	}


	
	
}
