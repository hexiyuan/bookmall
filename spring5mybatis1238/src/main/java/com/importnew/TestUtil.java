package com.importnew;

import org.springframework.beans.factory.annotation.Autowired;

public class TestUtil {
	/**
	 *构造器：需要传递参数进来 
	 */
	/*@Autowired
	public  TestUtil(User user){
		this.user=user;
	}*/
	
	/**
	 * TestUtil 类中注入User类
	 * spring提供@Autowired注解来提供依赖注入，以下几点需要分清：
	 * 1.bean还是需要注入到spring容器的，但是不需要在配置关系。
	 * 2.Autowired注解就可比喻成媒婆，它可以配置关系。
	 */
	@Autowired
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean getUserInfo(){
		if(user!= null){
			return true;
		}else{
			return false;
		}
		
	}
	
}
