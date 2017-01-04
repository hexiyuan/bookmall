package core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import core.domain.Order;

@Component
public interface OrderDao {

//	@Insert(value = "insert into orders values(#{id},#{ordertime},#{state},#{price},#{user.id})")
	public void addOrder(Order order) throws Exception;

	//select  *  from (orders inner join user on orders.user_id=user.id) inner join orderitem on orders.user_id=orderitem.order_id;
	//需要根据order的id进行多表查询
	public List<Order> findOrderById(@Param("id") String id) throws Exception;
	
	// 根据状态来获得所有订单。state:true: state:false;
	//@Select(value = "select * from orders where state=#{state}")
	public List<Order> getAllOrder(@Param("state") boolean state) throws Exception;

	// 根据id来修改订单的状态（该状态表示是否已经发货）
	@Update(value = "update orders set state=#{state} where id=#{id}")
	public void updateOrder(@Param("id") String id, @Param("state") boolean state) throws Exception;

}