package core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import core.domain.Book;
import core.domain.Cart;
import core.domain.Category;
import core.domain.Order;
import core.domain.OrderItem;
import core.domain.User;

public interface BusinessService {
	
	//订单项orderitem添加
	public void addOrderItem(OrderItem orderitem) throws Exception;

	// 商品分类操作
	public void addCategory(Category category) throws Exception;

	public Category findCategoryById(String id)  throws Exception;

	public List<Category> getAllCategory() throws Exception;

	public void  deleteCategoryById(String id) throws Exception;

	// 书籍操作
	public void addBook(Book book)  throws Exception;

	public Book findBookById(String id) throws Exception;

	public List<Book> getBookByAll() throws Exception;

	public List<Book> pageQuery( String id, int startindex, int pagesize) throws Exception;

	public int getPageTotalRecord( String id)throws Exception;
	
	public void  deleteBookById( String id) throws Exception;


	// 用户操作
	public void addUser(User user) throws Exception;

	public User findUser(String username, String password) throws Exception;

	public User findUserById(String id) throws Exception;

	// 订单操作
	void saveOrder(Cart cart, User user) throws Exception;

	public List<Order> findOrderById(String id) throws Exception;
	
	public List<Order> getAllOrder(boolean state) throws Exception;

	public void updateOrder(String id, boolean state) throws Exception;

}