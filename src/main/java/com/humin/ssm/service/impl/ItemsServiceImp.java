/**
 * Mar 14, 2018
 */
package com.humin.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humin.ssm.exception.CustomException;
import com.humin.ssm.mapper.ItemsMapper;
import com.humin.ssm.mapper.ItemsMapperCustom;
import com.humin.ssm.po.Items;
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
@Service
public class ItemsServiceImp implements ItemsService{
	
	@Resource
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items == null){
			throw new CustomException("修改商品信息不存在！");
		}
		ItemsCustom itemsCustom = null;
		// 将items的属性值拷贝到itemsCustom
		if(items != null){
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
			
		return itemsCustom;
	}

	@Override
	public void updateItems(int id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
