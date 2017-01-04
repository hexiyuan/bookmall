package core.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//后台页面全局处理器
public class ExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exp) {
		
		GuilderException backGuilderException;
		//是自定义的异常
		if(exp instanceof GuilderException){
			backGuilderException = (GuilderException) exp;
		}else{
			//不是自定义的异常
			backGuilderException = new GuilderException("未知错误！");
		}
		
		String message = backGuilderException.getMessage();
		
		ModelAndView model = new ModelAndView();
		model.addObject(message);
		model.setViewName("message");
		return model;
	}

}
