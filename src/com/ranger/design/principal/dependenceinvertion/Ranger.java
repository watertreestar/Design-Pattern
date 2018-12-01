package com.ranger.design.principal.dependenceinvertion;

/**
 * 
 * @author Ranger
 * 低层模块
 */
public class Ranger {
	
	private ICourse icourse;
	
	/**
	 * 构造器注入
	 * @param icourse
	 */
	public Ranger(ICourse icourse) {
		this.icourse = icourse;
	}
	
	public Ranger() {}
	public void studyCourse() {
		icourse.studyCourse();
	}
	/**
	 * setter注入
	 * @param icourse
	 */
	public void setiCourse(ICourse icourse) {
		this.icourse = icourse;
	}
	
	
}
