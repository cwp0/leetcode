package weekend.contest.time20240407;

/**
 * @Program: Java
 * @Package: weekend.contest.time20240407
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/07 11:12
 * @Version: 1.0
 */
/*
给你一个整数数组 nums 和一个 非负 整数 k 。

一次操作中，你可以选择任一下标 i ，然后将 nums[i] 加 1 或者减 1 。

请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。

一个数组的 中位数 指的是数组按 非递减 顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。



示例 1：

输入：nums = [2,5,6,8,5], k = 4

输出：2

解释：我们将 nums[1] 和 nums[4] 减 1 得到 [2, 4, 6, 8, 4] 。现在数组的中位数等于 k 。所以答案为 2 。

示例 2：

输入：nums = [2,5,6,8,5], k = 7

输出：3

解释：我们将 nums[1] 增加 1 两次，并且将 nums[2] 增加 1 一次，得到 [2, 7, 7, 8, 5] 。结果数组的中位数等于 k 。所以答案为 3 。

示例 3：

输入：nums = [1,2,3,4,5,6], k = 4

输出：0

解释：数组中位数已经等于 k 了，所以不需要进行任何操作。



提示：

1 <= nums.length <= 2 * 105
1 <= nums[i] <= 109
1 <= k <= 109
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] nums1 = {2, 5, 6, 8, 5};
        int k1 = 4;
        int[] nums2 = {2, 5, 6, 8, 5};
        int k2 = 7;
        int[] nums3 = {1, 2, 3, 4, 5, 6};
        int k3 = 4;
        System.out.println(q3.minOperationsToMakeMedianK(nums1, k1));
        System.out.println(q3.minOperationsToMakeMedianK(nums2, k2));
        System.out.println(q3.minOperationsToMakeMedianK(nums3, k3));
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[n/2] == k) {
            return 0;
        }
        long res = 0;
        res += Math.abs(nums[n/2] - k);
        nums[n/2] = k;
        for (int i = 0; i < n/2; i++) {
            if (nums[i] > nums[n/2]) {
                res += nums[i] - nums[n/2];
            }
        }
        for (int j = n/2 + 1; j < n; j++) {
            if (nums[j] < nums[n/2]) {
                res += nums[n/2] - nums[j];
            }
        }
        return res;
    }
}