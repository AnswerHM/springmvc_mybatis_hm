/**
 * Mar 12, 2018
 */
package com.humin.ssm.mapper;

import java.util.List;

import com.humin.ssm.po.ItemsCustom;
import com.humin.ssm.po.ItemsQueryVo;

/** 
 * @ClassName: ItemsMapperCustom 
 * @Description: 
 * @author humin 
 * @date Mar 12, 2018 1:50:57 PM 
 *  
 */
public interface ItemsMapperCustom {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
