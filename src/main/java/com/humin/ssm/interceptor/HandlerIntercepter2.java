package com.humin.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试拦截器1
 * @author humin
 *
 */
public class HandlerIntercepter2 implements HandlerInterceptor{
	// 进入handler方法之前执行
	// 用于身份认证、身份授权
	// 例如身份认证，如果认证未通过，表示当前用户没有登录，需要此方法拦截不再向下执行。
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return false 表示拦截，不向下执行
		// return true 表示放行
		System.out.println("HandlerIntercepter2============preHandle");
		return true;
	}
	// 进入handler方法之后，返回modelAndView之前执行
	// 应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到试图，页可以在这里统一制定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerIntercepter2============postHandle");
		
	}
	// 执行Handler完成执行此方法
	// 应用场景：统一的异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerIntercepter2============afterCompletion");
		
	}

}
