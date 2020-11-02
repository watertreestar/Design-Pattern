package com.ranger.design.principal.interfacesegragation;

/**
 * @Author ranger
 * @Date 2020/11/3 0:20
 **/
public class DogAfter implements IEatAnimalAction,ISwimAnimalAction {
    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    @Override
    public void swim() {
        System.out.println("dog swim");
    }
}
