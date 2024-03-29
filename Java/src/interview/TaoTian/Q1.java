package interview.TaoTian;

/**
 * @Program: Java
 * @Package: interview.TaoTian
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/29 16:42
 * @Version: 1.0
 */

/*
Java ACM模式

输入包括三行
第一行两个正整数 n m （1<= n，m <= 10^5）
第二行n 个整数 ai(0<= ai <= 10^9)
第三行m个整数bj(0<=bj<=10^9)

每次将n个整数中最小的数,依次加上m中的数，直到m中的数被加完，每次加m中的数后，输出n中数字的最大值。

示例
输入：
5 6
1145 1500 1600 1538 1222
10 400 500 1000 2000 10000

输出
1600
1600
1722
2500
3538
11555

说明
共加了6轮，前两轮后1145变为了1555，第三次使用最低的1222加500变为1722 成为最大值，将其打印。
 */

public class Q1 {
}