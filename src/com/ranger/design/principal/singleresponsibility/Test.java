/**
 * 
 */
package com.ranger.design.principal.singleresponsibility;

/**
 * @author Ranger
 *
 */
public class Test {
	public static void main(String[] args) {
		// v1
//		Bird bird = new Bird();
//		bird.mainMoveModel("乌鸦");
//		bird.mainMoveModel("大雁");
//		
//		bird.mainMoveModel("鸵鸟");    // 鸵鸟不能用翅膀飞
		
		FlyBird flyBird = new FlyBird();
		flyBird.mainMoveModel("大雁");
		
		WalkBird walkBird = new WalkBird();
		flyBird.mainMoveModel("鸵鸟");
	}
}
