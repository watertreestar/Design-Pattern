/**
 * 
 */
package com.ranger.design.principal.dependenceinvertion;

/**
 * @author Ranger
 * 高层模块
 */
public class Test {
	// v1
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger();
//		ranger.studyJavaCourse();
//		ranger.studyFECourse();
//	}
	
	// v2 接口方法注入	
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger();
//		// 构建一个课程内
//		ICourse javaCourse = new JavaCourse();
//		ranger.studyCourse(javaCourse);
//	}
	
	// v3 构造器注入
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger(new JavaCourse());
//		ranger.studyCourse();
//	}
	
	// v4 setter 注入
	public static void main(String[] args) {
		Ranger ranger = new Ranger();
		ranger.setiCourse(new JavaCourse());
		ranger.studyCourse();
	}
}
