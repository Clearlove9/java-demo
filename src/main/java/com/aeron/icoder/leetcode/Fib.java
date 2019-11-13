package com.aeron.icoder.leetcode;

public class Fib {
    public static void main(String[] args) {
        System.out.println(Fib2(1));
        System.out.println(Fib2(2));
        System.out.println(Fib2(3));
        System.out.println(Fib2(4));
        System.out.println(Fib2(5));
        System.out.println(Fib2(6));
    }

    private static int Fib1(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }
        return Fib1(n - 1) + Fib1(n - 2);
    }

    private static int Fib2(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int sum;
        for (int i = 1; i <= n - 2; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
