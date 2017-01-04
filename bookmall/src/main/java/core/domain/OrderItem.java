package core.domain;

public class OrderItem {
	
	private String id;
	private int quantity;  //总数量
	private double price;  //总价
	
	private String orderId; //该属性用来记住 orderitem表中的外键order_id
	private Book book;   
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", orderId=" + orderId
				+ ", book=" + book + "]";
	}

	

	
	
}
