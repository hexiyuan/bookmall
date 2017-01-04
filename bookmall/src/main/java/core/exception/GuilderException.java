package core.exception;
/**
 * 后台页面全局异常
 * 全局异常处理器处理思路：
 * 1.首先该servletdiscatption需要解析出该异常的类型
 * 如果该异常类型是自定义异常：则直接取出异常信息在页面展示！
 * 如果该异常是非自定义异常，则我们需要自己构造一个自定义异常
 *   它显示“未知错误！”
*/
public class GuilderException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public GuilderException(String message){
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
