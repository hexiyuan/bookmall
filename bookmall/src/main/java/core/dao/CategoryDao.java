package core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import core.domain.Category;

@Component
public interface CategoryDao {

	@Insert(value="insert into category values(#{id},#{name},#{description})")
	public void addCategory(Category category) throws Exception;

	@Select(value="select * from category where id=#{id}")
	public Category findCategoryById(@Param("id") String id) throws Exception;

	@Select(value="select * from category")
	public List<Category> getAllCategory() throws Exception;
	
	@Delete(value="delete from category where id=#{id}")
	public void  deleteCategoryById(@Param("id") String id) throws Exception;

}