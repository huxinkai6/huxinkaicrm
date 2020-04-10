package com.hxk.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hxk.tools.RedisTrans;



public class LoginInterceptor implements HandlerInterceptor {

	@Resource
	private RedisTrans redisTrans;


	/**
	 * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
	 * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断
	 * （如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
				// 将data数据进行响应
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		// 支持跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String uri = request.getRequestURI();
		if (uri.indexOf("/sessionTime") >= 0) {
			return true;
		}
		
		
		
		
		if (uri.indexOf("login") > 0) {
			System.out.println("1213");
			return true;
		} else {
			String uid = redisTrans.getString("UserId");
			System.out.println("1213" + uid);
			if (uid != "") {
				return true;
			}
			response.sendRedirect("file:///C:/Users/%E5%B0%8F%E5%87%AF/Desktop/Web/Web/login.html");
			return false;
		}

		
		
	}

	/**
	 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以
	 * 通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间
	 * 还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
