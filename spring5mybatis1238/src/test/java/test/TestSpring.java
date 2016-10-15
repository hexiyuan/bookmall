package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.importnew.TestUtil;
import com.importnew.User;

public class TestSpring {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUtil testUtil = (TestUtil) context.getBean("testUtil");
		
		if(testUtil.getUserInfo()){
			User user = testUtil.getUser();
			System.out.println(user.getAge());
			System.out.println(user.getName());
			System.out.println(user.getSex());
			System.out.println(user.getTel());
		}
	}
}
