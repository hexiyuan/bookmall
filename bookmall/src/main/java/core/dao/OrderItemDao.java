package core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import core.domain.OrderItem;

@Component
public interface OrderItemDao {

	@Insert(value = "insert into orderitem values(#{id},#{quantity},#{price},#{book.id},#{orderId})")
	public void addOrderItem(OrderItem orderitem) throws Exception;

	//根据orderitme中的order_id来查询orderitem表与book表
	public List<OrderItem> findOrderItem_2Book(@Param("id") String id) throws Exception;
}
