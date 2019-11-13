package com.aeron.icoder.proxy;

public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject() {
        this.subject = new RealSubject();
    }

    @Override
    public void hello(String args) {
        System.out.println("proxy subject");
        subject.hello(args);
    }
}
