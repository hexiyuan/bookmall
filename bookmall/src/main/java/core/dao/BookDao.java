package core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import core.domain.Book;

@Component
public interface BookDao {

	//添加书籍
	public void addBook(Book book) throws Exception;
	
	//根据id实现书籍的查找
	public Book findBookById(@Param("id") String id) throws Exception;

	//根据id删除书籍
	public void  deleteBookById(@Param("id") String id) throws Exception;
	
	//查找到所有的书籍
	public List<Book> getBookByAll() throws Exception;

	//页面查询功能的实现
	//id：为书籍分类category的id
	//startindex：起始索引(从0开始)
	//pagesize：页面大小
	//@Select(value="select * from book where category_id=#{id} limit #{startindex},#{pagesize}")
	public List<Book> pageQuery(@Param("id") String id,
							@Param("startindex") int startindex, 
							@Param("pagesize")int pagesize) throws Exception;


	//获得查询的总记录数据
	public int getPageTotalRecord(@Param("id") String id)throws Exception;
	
}