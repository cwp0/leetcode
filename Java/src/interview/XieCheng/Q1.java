package interview.XieCheng;

import java.util.Scanner;

/**
 * @Program: cloudsim-package
 * @Package: org.cloudbus.fog
 * @Class: Main
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/28 20:08
 * @Version: 1.0
 */

/*
游游拿到了n个正整数a_i，她希望你求出这些数的阶乘全部乘在一起生成的大数有多少个因子。你能帮帮她吗？

输入描述
第一行输入一个正整数n。
第二行输入n个正整数a_i，用空格隔开。
1<= n<=200000
1<= a_i<= 10^6

一个整数，代表这个乘积的因子数量，由于答案可能过大，请对10^9+7取模。

实例
输入：
3
1 2 3
输出
6

说明
1！* 2！ * 3！ = 1 * 2 * 6 = 12
共有1，2,3,4,6,12 六个因子。
 */

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = 1000000007;
        long res = 1;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            res = (res * factorial(num, mod)) % mod;
        }

        long count = countFactors(res, mod);
        System.out.println(count);
    }

    public static long factorial(int n, long mod) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i) % mod;
        }
        return res;
    }

    public static long countFactors(long n, long mod) {
        long count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i * i != n) {
                    count++;
                }
            }
        }
        return count % mod;
    }
}