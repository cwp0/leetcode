package interview.AliYun;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.AliYun
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/21 13:46
 * @Version: 1.0
 */
/*
有n个宝箱，第i个宝箱中有ai个金币。每打开k个宝箱，下一个宝箱中的金币数量就翻倍（翻倍的宝箱不计入k个里面）。现在问通过安排宝箱的打开顺序最多可以获得多少金币？

输入描述
第一行两个整数n，k，代表宝箱的数量和翻倍一次所需要打开的宝箱数。
第二行输入n个正整数ai，代表每个宝箱中的金币数量。
1 <=n,k<= 10^5
1<=ai<=10^9

输出描述
第一行输出出一个正整数，代表拿到的金币数量最大值。
第二行输出n个正整数pi，代表打开宝箱的顺序
有多种方案时输出任意即可，只需要保证拿到的金币数是最大的。
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        in.close();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            // 最小堆
            pq.offer(new int[]{coins[i], i});
            // 最大堆
            pq1.offer(new int[]{coins[i], i});
        }

        int[] order = new int[n];
        int maxCoins = 0;
        int opened = 1;

        for (int i = 0; i < n; i++) {
            if (opened - k == 1) {
                // 从最大堆弹出一个元素x2
                int[] top = pq1.poll();
                maxCoins += 2 * top[0];
                order[i] = top[1] + 1;
                opened = 1;
            } else {
                // 从最小堆弹出一个元素
                int[] top = pq.poll();
                maxCoins += top[0];
                order[i] = top[1] + 1;
                opened++;
            }

        }

        System.out.println(maxCoins);
        for (int i = 0; i < n; i++) {
            System.out.print(order[i]);
            if (i != n-1) {
                System.out.print(" ");
            }
        }


    }
}