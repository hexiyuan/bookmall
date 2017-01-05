package core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.BookDao;
import core.dao.CategoryDao;
import core.dao.OrderDao;
import core.dao.OrderItemDao;
import core.dao.UserDao;
import core.domain.Book;
import core.domain.Cart;
import core.domain.CartItem;
import core.domain.Category;
import core.domain.Order;
import core.domain.OrderItem;
import core.domain.User;
import core.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	

	public void addCategory(Category category) throws Exception {
		categoryDao.addCategory(category);
	}

	public Category findCategoryById(String id) throws Exception {
		return categoryDao.findCategoryById(id);
	}

	public List<Category> getAllCategory() throws Exception {
		return categoryDao.getAllCategory();
	}

	public void addBook(Book book) throws Exception {
		bookDao.addBook(book);
	}

	public Book findBookById(String id) throws Exception {
		return bookDao.findBookById(id);
	}

	public List<Book> getBookByAll() throws Exception {
		return bookDao.getBookByAll();
	}

	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	public User findUser(String username, String password) throws Exception {
		return userDao.findUser(username, password);
	}

	public User findUserById(String id) throws Exception {
		return userDao.findUserById(id);
	}

	//用户的购物车产生订单对象，并保存数据
	public void saveOrder(Cart cart, User user) throws Exception {
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);

		//定义一个集合，用来保存所有的订单项
		List<OrderItem> oitems = new ArrayList<OrderItem>();
		//用购物车中的购物项生成订单项
		Set<Map.Entry<String, CartItem>> set = cart.getMap().entrySet();
		for(Map.Entry<String, CartItem> entry : set){
			CartItem citem = entry.getValue();   //得到每一个购物项
			OrderItem oitem = new OrderItem();
			//用购物车中的购物项生成订单项
			oitem.setBook(citem.getBook());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			oitems.add(oitem);		//将所有的订单项加入到集合中
		}
		order.setOrderitems(oitems);
		
		//将这个订单项集合加入到订单order中
		orderDao.addOrder(order);
		
		//将购物车中的信息存入数据库订单项中（orderitem）
		for(OrderItem om:oitems){
			om.setOrderId(order.getId());
			orderItemDao.addOrderItem(om);
		}
	}

	public List<Order> findOrderById(String id) throws Exception {
		return orderDao.findOrderById(id);
	}
	

	public List<Order> getAllOrder(boolean state) throws Exception {
		return orderDao.getAllOrder(state);
	}
	public Order findOrderById_2User(String id) throws Exception {
		return orderDao.findOrderById_2User(id);
	}
	public void updateOrder(String id, boolean state) throws Exception {
		orderDao.updateOrder(id, state);
	}

	public List<Book> pageQuery(String id, int startindex, int pagesize) throws Exception {
		return bookDao.pageQuery(id, startindex, pagesize);
	}

	public int getPageTotalRecord(String id) throws Exception {
		return bookDao.getPageTotalRecord(id);
	}

	public void deleteBookById(String id) throws Exception {
		bookDao.deleteBookById(id);
	}

	public void deleteCategoryById(String id) throws Exception {
		categoryDao.deleteCategoryById(id);
	}

	
	public void addOrderItem(OrderItem orderitem) throws Exception {
		orderItemDao.addOrderItem(orderitem);
	}

	public List<OrderItem> findOrderItem_2Book(String id) throws Exception {
		return orderItemDao.findOrderItem_2Book(id);
	}





}
