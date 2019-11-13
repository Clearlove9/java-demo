package com.aeron.icoder.proxy;

public class RealSubject implements Subject {

    @Override
    public void hello(String args) {
        System.out.println(args);
    }
}
