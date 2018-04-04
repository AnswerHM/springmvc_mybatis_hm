package com.humin.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登陆拦截器
 * @author humin
 *
 */
public class LoginIntercepter implements HandlerInterceptor{
	// 进入handler方法之前执行
	// 用于身份认证、身份授权
	// 例如身份认证，如果认证未通过，表示当前用户没有登录，需要此方法拦截不再向下执行。
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否是公开地址（实际使用时将公开地址配置在配置文件中）
		if(url.indexOf("login.action")>0){
			// 如果进行登陆提交，放行
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		if(username != null){
			return true;
		}
		// 执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		// return false 表示拦截，不向下执行
		// return true 表示放行
		return false;
	}
	// 进入handler方法之后，返回modelAndView之前执行
	// 应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到试图，页可以在这里统一制定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	// 执行Handler完成执行此方法
	// 应用场景：统一的异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
