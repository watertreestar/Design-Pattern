package com.ranger.design.principal.openclose;


import com.ranger.design.principal.openclose.ICourse;

/**
 * 开闭原则:
 * 场景：
 * 课程现在遇到优惠活动需要打折，那么如何添加这个功能呢？
 * 1> 我们最先想到的就是在ICourse接口中添加一个方法返回打折价格：getDiscountPrice()
 * 	      然后再类中实现这个方法，然后在获取价格的时候调用getDiscountPrice方法
 * 
 * 2> 修改原来的getPrice方法   缺点：不能获取原价
 * 
 * 3> 新建一个基于JavaCourse的子类JavaDiscountCourse，新增加方法getDiscountPrice()和getOriginPrice()
 * @author WaterTree
 *
 */
public class JavaCourse implements ICourse {
	private Integer id;
	
	private String name;
	
	private Double price;
	
	public JavaCourse(Integer id,String name,Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public JavaCourse() {}
	
	
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}
	
}
