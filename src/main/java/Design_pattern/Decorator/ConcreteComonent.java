package com.jinxiu.netty.Decorator;

public class ConcreteComonent implements Component{
    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
