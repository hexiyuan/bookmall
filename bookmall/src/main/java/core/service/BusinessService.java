package core.service;

import java.util.List;

import core.domain.Book;
import core.domain.Cart;
import core.domain.Category;
import core.domain.Order;
import core.domain.OrderItem;
import core.domain.User;

public interface BusinessService {
	
	//orderitem订单项操作
	public void addOrderItem(OrderItem orderitem) throws Exception;
	
	public List<OrderItem> findOrderItem_2Book(String id) throws Exception;

	// category商品分类操作
	public void addCategory(Category category) throws Exception;

	public Category findCategoryById(String id)  throws Exception;

	public List<Category> getAllCategory() throws Exception;

	public void  deleteCategoryById(String id) throws Exception;

	// book书籍操作
	public void addBook(Book book)  throws Exception;

	public Book findBookById(String id) throws Exception;

	public List<Book> getBookByAll() throws Exception;

	public List<Book> pageQuery( String id, int startindex, int pagesize) throws Exception;

	public int getPageTotalRecord( String id)throws Exception;
	
	public void  deleteBookById( String id) throws Exception;


	// user用户操作
	public void addUser(User user) throws Exception;

	public User findUser(String username, String password) throws Exception;

	public User findUserById(String id) throws Exception;
	
	public List<String> genOrdersIdByUser(String id) throws Exception;

	// order订单操作
	void saveOrder(Cart cart, User user) throws Exception;

	public List<Order> findOrderById(String id) throws Exception;
	
	public List<Order> getAllOrder(boolean state) throws Exception;

	public void updateOrder(String id, boolean state) throws Exception;
	
	public Order findOrderById_2User(String id) throws Exception;


}