/**
 * 
 */
package com.ranger.design.principal.singleresponsibility;

/**
 * @author Ranger
 *
 */
public interface ICourse {
	String getCourseName();
	byte[] getCourseVideo();
	
	void studyCourse();
	void refundCourse();
}
