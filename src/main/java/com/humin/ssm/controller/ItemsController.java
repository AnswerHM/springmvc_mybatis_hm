/**
 * Mar 14, 2018
 */
package com.humin.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
// 为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
// 例如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController {
	@Resource
	ItemsServiceImp ItemsService;
	
	// 商品查询列表
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception{
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
	
//	//商品信息修改页面显示
////	@RequestMapping("/editItems")
//	// 限制http请求方法,可以是post和get
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		
//		// 调用service根据商品id查询商品信息
//		ItemsCustom itemsCustom = ItemsService.findItemsById(1);
//		
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// 将商品信息放到model
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		
//		// 商品修改页面
//		modelAndView.setViewName("/items/itemsList");
//		
//		return modelAndView;
//	}
	
	//商品信息修改页面显示
	// 限制http请求方法,可以是post和get
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入。
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认和形参绑定。
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="") Integer items_id) throws Exception{
		
		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = ItemsService.findItemsById(items_id);
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom",itemsCustom);
		
		return "/items/itemsList";
	}
	
	// 商品修改提交
	@RequestMapping("editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request) throws Exception{
		// 调用service更新商品信息，页面需要将商品信息传到此防范
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 重定向到商品查询列表
//		return "redirect:queryItems.action";
		// 转发
		return "forward:queryItems.action";
//		return "success";
	}
	
	
}
