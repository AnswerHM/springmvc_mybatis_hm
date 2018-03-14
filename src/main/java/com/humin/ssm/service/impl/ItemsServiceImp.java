/**
 * Mar 14, 2018
 */
package com.humin.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.humin.ssm.mapper.ItemsMapper;
import com.humin.ssm.mapper.ItemsMapperCustom;
import com.humin.ssm.po.ItemsCustom;
import com.humin.ssm.po.ItemsQueryVo;
import com.humin.ssm.service.ItemsService;

/** 
 * @ClassName: ItemsServiceImp 
 * @Description: 
 * @author humin 
 * @date Mar 14, 2018 2:17:56 PM 
 *  
 */
public class ItemsServiceImp implements ItemsService{
	
	@Resource
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper ItemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItems(int id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
