package core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import core.domain.Order;

@Component
public interface OrderDao {

	public void addOrder(Order order) throws Exception;

	//需要根据order的id进行多表查询(查询四张表：user/orders/orderitem/book)
	public List<Order> findOrderById(@Param("id") String id) throws Exception;
	
	//需要根据order的id进行多表查询(查询2张表：user/orders)
	public Order findOrderById_2User(@Param("id") String id) throws Exception;
	
	// 根据状态来获得所有订单。state:true: state:false;
	public List<Order> getAllOrder(@Param("state") boolean state) throws Exception;

	// 根据id来修改订单的状态（该状态表示是否已经发货）
	@Update(value = "update orders set state=#{state} where id=#{id}")
	public void updateOrder(@Param("id") String id, @Param("state") boolean state) throws Exception;

}