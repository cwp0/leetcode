package interview.MeiTuan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 19:36
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(zeroCount(nums, n, k));

    }

    private static int zeroCount(int[] nums, int n, long k) {
        int res = 0;
        // 先加上nums中原本就有的0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res += 1;
            }
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        // 然后再加上经过k次加减1后得到的0
        for (int i = 0; i < n; i++) {
            if (k >= 0 && nums[i] != 0) {
                res += 1;
                k -= nums[i];
            }
        }
        res -= 1;

        return res;
    }

}