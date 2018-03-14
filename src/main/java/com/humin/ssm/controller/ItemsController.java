/**
 * Mar 14, 2018
 */
package com.humin.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.humin.ssm.po.ItemsCustom;
import com.humin.ssm.service.impl.ItemsServiceImp;

/** 
 * @ClassName: ItemsController 
 * @Description: 
 * @author humin 
 * @date Mar 14, 2018 2:57:47 PM 
 *  
 */
@Controller
public class ItemsController {
	@Resource
	ItemsServiceImp ItemsService;
	
	// 商品查询列表
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		List<ItemsCustom> itemsList = ItemsService.findItemsList(null);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute 在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList",itemsList);
		
		// 指定视图
		// 下面的路径，如果在视图解析器中配置jsp路径的前缀和jsp的后缀，修改为：
//		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上面的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("/items/itemsList");
		
		return modelAndView;
	}
}
