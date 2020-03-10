package com.dadisdad.coding;

/**
 * 斐波那契数列
 *
 * @author 10308
 * @date 2020/3/11
 */
public class Fibonacci {

    public static int fibonacciRecursice(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursice(n - 1) + fibonacciRecursice(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int one = 0;
        int two = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = one + two;
            if (result > 1000000007) {
                result -= 1000000007;
            }
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciIterative(50));
        System.out.println(fibonacciIterative(50));
    }
}
