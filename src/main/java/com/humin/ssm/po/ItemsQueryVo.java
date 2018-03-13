/**
 * Mar 12, 2018
 */
package com.humin.ssm.po;

/** 
 * @ClassName: ItemsQueryVo 
 * @Description: 商品包装对象
 * @author humin 
 * @date Mar 12, 2018 1:56:04 PM 
 *  
 */
public class ItemsQueryVo {
	
	// 商品信息
	private Items items;
	
	// 为了系统扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
}
