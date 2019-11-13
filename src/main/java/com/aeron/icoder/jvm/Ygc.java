package com.aeron.icoder.jvm;

public class Ygc {
    public static void main(String[] args) {
        byte[] arr = new byte[1024 * 1024];
        arr = new byte[1024 * 1024];
        arr = new byte[1024 * 1024];

        arr = null;

        byte[] brr = new byte[2 * 1024 * 1024];
    }
}
