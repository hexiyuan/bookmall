package test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.dao.OrderItemDao;
import core.domain.Book;
import core.domain.Order;
import core.domain.OrderItem;

public class OrederItemTest {

	// 结合spring与mybatis来测试dao层
		private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		@Test
		public void daoTestFind() throws Exception{
			OrderItemDao orderItem = (OrderItemDao) context.getBean("orderItemDao");
			OrderItem orderitem = new OrderItem();
			orderitem.setId(UUID.randomUUID().toString());
	//		orderitem.setOrderId("33765748-26cc-4ca3-a75a-004b5153c0b1");
			orderitem.setPrice(466);
			orderitem.setQuantity(2);
			Book book = new Book();
			book.setId("0baa1cd2-7bf0-4c17-929d-8c5ba37a6af5");
			orderitem.setBook(book);
			orderItem.addOrderItem(orderitem);
			
		}
		
		@Test
		public void testFindOrderItemByOrderId() throws Exception{
			OrderItemDao orderItem = (OrderItemDao) context.getBean("orderItemDao");
			List<OrderItem> oi =  orderItem.findOrderItemByOrderId("d84bfd47-1e4d-4a0a-907f-d358415990b9");
			for (int i = 0; i < oi.size(); i++) {
				System.out.println(oi.get(i));
			}
			
		}
		

}
