/**
 * Mar 12, 2018
 */
package com.humin.ssm.mapper;

import com.humin.ssm.po.Items;

/** 
 * @ClassName: ItemsMapper 
 * @Description: 
 * @author humin 
 * @date Mar 12, 2018 1:43:19 PM 
 *  
 */
public interface ItemsMapper {
	public Items selectByPrimaryKey(Integer id);
}
