package com.ranger.design.principal.interfacesegragation;

/**
 * @Author ranger
 * @Date 2020/11/3 0:16
 **/
public class Bird implements IAnimalAction {
    @Override
    public void eat() {
        System.out.println("bird eat");
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
