package com.ranger.design.principal;

import com.ranger.design.principal.openclose.JavaCourse;

/**
 * 
 * @author WaterTree
 *
 */
public class JavaDiscountCourse extends JavaCourse {

	public JavaDiscountCourse(Integer id, String name, Double price) {
		super(id, name, price);
		
	}

	@Override
	public Double getPrice() {
		// 大于200就打折
		if(super.getPrice() > 200) {
			return super.getPrice()*0.8;
		}
		return super.getPrice();
	}
	
	public Double getOriginPrice() {
		return super.getPrice();
	}

}
