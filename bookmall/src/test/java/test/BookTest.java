package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.dao.BookDao;
import core.domain.Book;
import core.domain.Category;

public class BookTest {

	//结合spring与mybatis来测试dao层
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void daoTestFind() throws Exception{
		BookDao bookdao = (BookDao) context.getBean("bookDao");
		Book bk = bookdao.findBookById("");
		System.out.println(bk);
	}
	
	@Test
	public void daoTestAdd() throws Exception{
		BookDao bookdao = (BookDao) context.getBean("bookDao");
		Category category = new Category();
		category.setId("1");
		Book bk = new Book();
		bk.setCategory(category);
		bk.setAuthor("Maama");
		bk.setDescription("这是mama写的一本小说书！");
		bk.setId("9");
		bk.setName("新月传奇2");
		bk.setImage("20112333");
		bk.setPrice(28);
		
		bookdao.addBook(bk);
		
	}
	
	@Test
	public void daoTestGetAll() throws Exception{
		BookDao bookdao = (BookDao) context.getBean("bookDao");
		List<Book> books = bookdao.getBookByAll();
		for(Book book:books){
			System.out.println(book);
		}
	}
	
	//测试删除book
	@Test
	public void daoTestdeleteBookById() throws Exception{
		BookDao bookdao = (BookDao) context.getBean("bookDao");
		bookdao.deleteBookById("1");
	}
	
	
	//页面查询
	@Test
	public void testPageQuery() throws Exception{
		BookDao bookdao = (BookDao) context.getBean("bookDao");
		List<Book> qr = bookdao.pageQuery("24bd1f75-36a4-4707-a4c8-f751283e7eb3", 0, 3);
		System.out.println(qr);
	}
	
	//总记录数查询
		@Test
		public void testPageTotalRecord() throws Exception{
			BookDao bookdao = (BookDao) context.getBean("bookDao");
			int qr = bookdao.getPageTotalRecord("24bd1f75-36a4-4707-a4c8-f751283e7eb3");
			System.out.println(qr);
		}
	
}
