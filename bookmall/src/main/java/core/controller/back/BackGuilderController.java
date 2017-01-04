package core.controller.back;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import core.domain.Book;
import core.domain.Category;
import core.domain.Order;
import core.service.BusinessService;

/**
 * 后台页面controller控制中心
 * @author user
 */

@Controller
@RequestMapping("/back")
public class BackGuilderController {

	@Autowired
	private BusinessService BusinessServiceImpl;

	// 执行首页跳转
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexController(Model model) throws Exception {
		return "manager";
	}

	// 添加商品种类
	@RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
	public String categoryAdd(Model model, Category category) throws Exception {
		String message = "";
		try {
			String id = UUID.randomUUID().toString();
			category.setId(id);
			BusinessServiceImpl.addCategory(category);
			message = "商品种类添加成功";
			model.addAttribute("message", message);
		} catch (Exception e) {
			message = "商品种类添加失败！";
			model.addAttribute("message", message);
		}
		return "message";
	}

	// 查看商品分类信息
	@RequestMapping(value = "/listcategory", method = RequestMethod.GET)
	public String listCategory(Model model) throws Exception {
		List<Category> categories = BusinessServiceImpl.getAllCategory();
		model.addAttribute("categories", categories);
		return "listcategory";
	}

	// 在添加书籍之前，将“种类分类”信息带过去并显示在页面中！
	@RequestMapping("/addbook")
	public String beforeAddBook(Model model) throws Exception {
		// 在跳转到addbook页面之前，需要从数据库中得到所有的“种类分类”信息
		List<Category> categories = BusinessServiceImpl.getAllCategory();
		model.addAttribute("categories", categories);
		return "addbook";
	}

	// 添加图书(有图片上传的功能)
	@RequestMapping(value = "/addBookPage", method = RequestMethod.POST)
	public String addBook(Model model, Book book) throws Exception {
		String message = "";
		try {
			String id = UUID.randomUUID().toString();
			book.setId(id);
			BusinessServiceImpl.addBook(book);
			message = "图书添加成功";
			model.addAttribute("message", message);
		} catch (Exception e) {
			message = "图书添加失败！";
			model.addAttribute("message", message);
		}
		return "message";
	}

	// 查看图书 listbook
	@RequestMapping(value = "/listbook", method = RequestMethod.GET)
	public String listBook(Model model) throws Exception {
		try {
			List<Book> list = BusinessServiceImpl.getBookByAll();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listbook";
	}

	// 待处理订单 + 待发货订单
	@RequestMapping(value = "/orderToResolve", method = RequestMethod.GET)
	public String orderToResolve(Model model, boolean state) throws Exception {
		try {
			List<Order> list = BusinessServiceImpl.getAllOrder(state);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listorder";
	}

	// 查看订单明细 orderdetail
	//传过来的id为订单orders的id
	@RequestMapping(value = "/orderdetail", method = RequestMethod.GET)
	public String orderdetail(Model model, String id) throws Exception {
		String message = "";
		try {
			List<Order> order = BusinessServiceImpl.findOrderById(id);
			model.addAttribute("order", order);
			
		} catch (Exception e) {
			model.addAttribute("查看失败！", message);
			return "message";
		}
		return "orderdetail";
	}

	// 根据id来删除图书
	@RequestMapping(value = "/deletebook", method = RequestMethod.GET)
	public String deleteBook(Model model, String id) throws Exception {
		try {
			BusinessServiceImpl.deleteBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/back/listbook.back";
	}

	// 根据id来删除category分类
	@RequestMapping(value = "/deletecategory", method = RequestMethod.GET)
	public String TestDeleteCategory(Model model, String id) throws Exception {
		try {
			BusinessServiceImpl.deleteCategoryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/back/listcategory.back";
	}


	// jsp页面链接请求的1级跳转控制
	@RequestMapping(value = "{pageName1}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("pageName1") String pageName1) {
		ModelAndView mv = new ModelAndView(pageName1);
		return mv;
	}
}
