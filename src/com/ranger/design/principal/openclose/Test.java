package com.ranger.design.principal.openclose;

public class Test {
	public static void main(String[] args) {
		ICourse icourse = new com.ranger.design.principal.JavaDiscountCourse(96,"Java设计模式",399d);
		com.ranger.design.principal.JavaDiscountCourse javaCourse = (com.ranger.design.principal.JavaDiscountCourse)icourse;
		System.out.println("课程ID："+javaCourse.getId()+
				"课程名称："+javaCourse.getName()+
				"课程原价："+javaCourse.getOriginPrice()+
				"课程折扣价格："+javaCourse.getPrice());
	}
}
