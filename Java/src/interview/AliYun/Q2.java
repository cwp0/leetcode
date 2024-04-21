package interview.AliYun;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.AliYun
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/21 13:46
 * @Version: 1.0
 */
/*
长度为n的数组a，有多少个不同的长度为n的排列满足对于i属于[1,n], pi != ai？
所谓排列，指的是一个长度为n的数组，其中1到n每个元素恰好出现1次。

输入描述
第一行一个正整数n，代表数组的大小。
第二行输入n个正整数ai，代表数组的元素
1<=ai,n<=10

输出描述
一个整数，代表符合要求的排列p的数量。
 */
public class Q2 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        boolean[] used = new boolean[n];
        // 从位置1开始递归生成排列
        generatePermutations(a, used, 0);

        System.out.println(count);
    }

    // 递归生成排列
    private static void generatePermutations(int[] a, boolean[] used, int pos) {
        if (pos == a.length) {
            // 当生成完一个排列时，检查是否满足条件
            for (int i = 0; i < a.length; i++) {
                if (a[i] == i + 1) {
                    return; // 如果某个位置的元素与原数组相同，直接返回
                }
            }
            count++; // 否则计数加一
            return;
        }

        // 递归地尝试所有可能的元素
        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                a[pos] = i + 1; // 尝试放置元素 i + 1 到位置 pos
                used[i] = true;
                generatePermutations(a, used, pos + 1);
                used[i] = false;
            }
        }
    }
}
