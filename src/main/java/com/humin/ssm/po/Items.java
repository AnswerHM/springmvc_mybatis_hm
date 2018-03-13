/**
 * Mar 12, 2018
 */
package com.humin.ssm.po;

import java.util.Date;

/** 
 * @ClassName: Items 
 * @Description: 
 * @author humin 
 * @date Mar 12, 2018 1:46:19 PM 
 *  
 */
public class Items {
	private Integer id;
	
	private String name;
	
	private Float price;
	
	private String pic;
	
	private Date createTime;
	
	private String detail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
