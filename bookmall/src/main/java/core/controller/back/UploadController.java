package core.controller.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import net.fckeditor.response.UploadResponse;

/**
 * 上传图片
 * 1.将图片上传到令一个服务器
 * 2.向客户端输出两个路径，以json的方式。
 */
@Controller
@RequestMapping(value = "/back")
public class UploadController {

	String oldpath = "http://localhost:8080/upload/";
	// 上传图片
	@RequestMapping(value = "/uploadpic")
	public void uploadPic(@RequestParam(value="pic",required = false) MultipartFile pic,
							HttpServletResponse response) throws Exception{
		String IMG_URL = "http://localhost:8080/upload/";

		// 实例化一个Jersey
		Client client = new Client();
		
		// 1.获得图片的扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());

		// 图片名称生成策略（不含扩展名）
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String format = df.format(new Date());	// 图片名称一部分
			
		// 2.保存数据库中的路径path 没有添加  "upload/"
		String path = format + "." + ext;	//修改后的
//		String path = "upload/"+ format + "." + ext;	//原来的

		// 另一台服务器的请求路径是?
//		String url = IMG_URL + path;				//原来的
		String url = IMG_URL  + path;	//修改后的
		
		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始 POST GET PUT
		byte[] buf = null;
		try {
			
			buf = FileUtil.readAsByteArray(pic.getInputStream());
			resource.put(String.class, buf);	//文件上传
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 第二步：向客户端输出两个路径。用json方式来输出。
		JSONObject jo = new JSONObject();
		jo.put("url", url);		//另一台服务器的请求路径: filepaht
		jo.put("path", path);	//保存数据库中的路径path: imageUrl
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(jo);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("success!");
	}
	


	// 上传Fck图片
	@RequestMapping(value = "/uploadFck")
	public void uploadFck(HttpServletRequest request, HttpServletResponse response) {
		// 强转request 支持多个
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		// 获取值 支持多个
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		// 遍历Map
		Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		for (Entry<String, MultipartFile> entry : entrySet) {
			// 上传上来的图片
			MultipartFile pic = entry.getValue();
			// 扩展名
			String ext = FilenameUtils.getExtension(pic.getOriginalFilename());

			// 图片名称生成策略
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			// 图片名称一部分
			String format = df.format(new Date());

			// 随机三位数
			Random r = new Random();
			// n 1000 0-999 99
			for (int i = 0; i < 3; i++) {
				format += r.nextInt(10);
			}

			// 实例化一个Jersey
			Client client = new Client();
			// 保存数据库
			String path = "upload/" + format + "." + ext;

			// 另一台服务器的请求路径是?
			String url = oldpath + path;
			// 设置请求路径
			WebResource resource = client.resource(url);

			// 发送开始 POST GET PUT
			try {
				resource.put(String.class, pic.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 返回Url给Fck fck-core...jar ckeditor
			UploadResponse ok = UploadResponse.getOK(url);
			// response 返回对象
			// response write
			// response print
			// 区别:
			// 字符流
			// 字节流
			try {
				response.getWriter().print(ok);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
