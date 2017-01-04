package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.dao.OrderDao;
import core.domain.Order;

public class OrderTest {

	// 结合spring与mybatis来测试dao层
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void daoTestFind() throws Exception{
		OrderDao orderdao = (OrderDao) context.getBean("orderDao");
		List<Order> order = orderdao.findOrderById("1");
		System.out.println(order);
	}


	@Test
	public void getAllOrder() throws Exception{
		OrderDao orderdao = (OrderDao) context.getBean("orderDao");
		List<Order> order = orderdao.getAllOrder(false);
		System.out.println(order);
	}
}
