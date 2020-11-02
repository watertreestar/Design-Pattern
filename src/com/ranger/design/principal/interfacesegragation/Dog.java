package com.ranger.design.principal.interfacesegragation;

/**
 * @Author ranger
 * @Date 2020/11/3 0:12
 **/
public class Dog implements IAnimalAction {
    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        System.out.println("dog swim");
    }
}
