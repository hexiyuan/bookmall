package core.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import core.domain.OrderItem;

@Component
public interface OrderItemDao {

	@Insert(value = "insert into orderitem values(#{id},#{quantity},#{price},#{book.id},#{orderId})")
	public void addOrderItem(OrderItem orderitem) throws Exception;

}
