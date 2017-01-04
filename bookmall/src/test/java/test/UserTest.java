package test;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.dao.OrderDao;
import core.domain.Order;
import core.domain.User;

public class UserTest {

	// 结合spring与mybatis来测试dao层
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// 添加订单
	@Test
	public void daoTestFind() throws Exception {
		String ss = "2011-11-11";
		Date date = DateUtils.parseDate(ss, "yy-DD-mm");
		OrderDao orderDao = (OrderDao) context.getBean("orderDao");
		Order order = new Order();
		order.setId("1");
		order.setOrdertime(date);
		order.setPrice(255.0);
		order.setState(false);
		User user = new User();
		user.setId("1");
		order.setUser(user);

		orderDao.addOrder(order);
	}

	@Test
	public void daoFindUser() {

	}

}
