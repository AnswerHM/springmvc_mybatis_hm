/**
 * Mar 14, 2018
 */
package com.humin.ssm.service;

import java.util.List;

import com.humin.ssm.po.ItemsCustom;
import com.humin.ssm.po.ItemsQueryVo;

/** 
 * @ClassName: ItemsService 
 * @Description: 
 * @author humin 
 * @date Mar 14, 2018 2:10:57 PM 
 *  
 */
public interface ItemsService {
	
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	public ItemsCustom findItemsById(int id) throws Exception;
	
	public void updateItems(int id,ItemsCustom itemsCustom) throws Exception;
}
