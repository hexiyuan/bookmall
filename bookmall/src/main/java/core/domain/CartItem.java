package core.domain;

public class CartItem {
	
	private int quantity;
	private double price;
	
	private Book book;
	
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		this.price = this.book.getPrice()*quantity;
		return price;
	}
}
