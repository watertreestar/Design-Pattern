package com.ranger.design.principal;

public class Test {
	public static void main(String[] args) {
		ICourse icourse = new JavaDiscountCourse(96,"Java设计模式",399d);
		JavaDiscountCourse javaCourse = (JavaDiscountCourse)icourse;
		System.out.println("课程ID："+javaCourse.getId()+
				"课程名称："+javaCourse.getName()+
				"课程原价："+javaCourse.getOriginPrice()+
				"课程折扣价格："+javaCourse.getPrice());
	}
}
