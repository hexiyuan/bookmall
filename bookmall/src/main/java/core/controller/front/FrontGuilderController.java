package core.controller.front;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import core.domain.Book;
import core.domain.Cart;
import core.domain.Category;
import core.domain.PageBean;
import core.domain.User;
import core.service.BusinessService;

/**
 * 前台访问页面controller控制
 * @author user
 */
@Controller
@RequestMapping("/front")
public class FrontGuilderController {
	@Autowired
	private BusinessService BusinessServiceImpl;

	// 执行用户登陆的验证
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, String username, String password) throws Exception {
		User user = BusinessServiceImpl.findUser(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/front/index.front";
		} else {
			 //throw new GuilderException("你输入的账号密码不正确！");
			String message = "你输入的账号密码不正确！请重新确认！";
			model.addAttribute("message", message);
			return "message";
		}
	}

	// 执行用户退出登陆请求
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			session.invalidate();
		}
		return "redirect:/front/index.front";
	}
	
	//执行用户购买商品操作
	@RequestMapping(value = "/buy")
	public String forBuyer(Model model,HttpSession session,String id) throws Exception {
			Book book = BusinessServiceImpl.findBookById(id);
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart==null){
				cart = new Cart();
				session.setAttribute("cart", cart);
			}
			cart.add(book);
			return "redirect:/front/listcart.front";
	
	}
	
	//生成订单处理  ordercuster
	@RequestMapping(value = "/ordercuster")
	public String forOrderCuster(Model model, HttpSession session, String id) throws Exception {
		// 获得session中的用户信息，并进行判断
		User user = (User) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("message", "请先登陆！");
			return "message";
		}
		try {
			//获得session中有关cart购物车相关的信息
			Cart cart = (Cart) session.getAttribute("cart");
			//调用saveOrder方法进行保存
			BusinessServiceImpl.saveOrder(cart, user);
			model.addAttribute("message", "订单生成成功，请等待发货！");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "失败！");
		}
		return "message";
	}

	// 执行用户注册功能
	@RequestMapping(value = "/registerFrom", method = RequestMethod.POST)
	public String registerFrom(Model model, User user) throws Exception {
		// 这里直接使用User表来封装表单信息
		// 也可以使用json来提交数据 可以直接使用jquery在前台对表单进行第一次校验！
		String message = "";
		try {
			user.setId(UUID.randomUUID().toString());
			// ...添加表单校验
			BusinessServiceImpl.addUser(user);
			message = "恭喜你，注册成功！";
		} catch (Exception e) {
			message = "出现异常！请核对之后再提交！";
		}
		model.addAttribute("message", message);
		return "message";
	}

	// 处理分页请求
	@RequestMapping(value = "/index")
	public String bookQueryResult(Model model,HttpServletRequest request,
			@RequestParam(value = "categoryId",defaultValue = "all") String categoryId,
			@RequestParam(value = "currentpage", defaultValue = "1") Integer currentpage,
			@RequestParam(value = "pagesize", defaultValue = "6") Integer pagesize) {
		try {
			// 获得页面所需分类展示信息
			List<Category> categories = BusinessServiceImpl.getAllCategory();
			model.addAttribute("categories", categories);
			// 获得该分类下的总记录数据
			int totalrecord = BusinessServiceImpl.getPageTotalRecord(categoryId);
			List<Book> list = BusinessServiceImpl.pageQuery(categoryId, (currentpage - 1)*pagesize, pagesize);
			PageBean pagebean = new PageBean();
			pagebean.setList(list);
			pagebean.setTotalrecord(totalrecord);
			pagebean.setCurrentpage(currentpage);
			pagebean.setPagesize(pagesize);
			model.addAttribute("pagebean", pagebean);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "异常出现");
			return "message";
		}
		return "index";
	}

	
	// jsp页面链接请求的1级跳转控制
	@RequestMapping(value = "{pageName1}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("pageName1") String pageName1) {
		ModelAndView mv = new ModelAndView(pageName1);
		return mv;
	}

	 // jsp页面链接请求的2级跳转控制
	 @RequestMapping(value = "{pageName1}/{pageName2}", method =RequestMethod.GET)
	 public ModelAndView toPageFroward(
			 @PathVariable("pageName1") String pageName1,
			 @PathVariable("pageName2") String pageName2) {
	 ModelAndView mv = new ModelAndView(pageName1 + "/" + pageName2);
	 return mv;
	 }

}
