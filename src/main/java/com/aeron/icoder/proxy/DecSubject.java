package com.aeron.icoder.proxy;

public class DecSubject implements Subject {
    private Subject subject;

    public DecSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void hello(String args) {
        System.out.println("dec subject");
        subject.hello(args);
    }
}
