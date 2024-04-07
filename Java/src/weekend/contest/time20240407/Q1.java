package weekend.contest.time20240407;

/**
 * @Program: Java
 * @Package: weekend.contest
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/07 10:36
 * @Version: 1.0
 */

/*
给你一个整数数组 nums 。

返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。



示例 1：

输入：nums = [1,4,3,3,2]

输出：2

解释：

nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。

nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。

因此，返回 2 。

示例 2：

输入：nums = [3,3,3,3]

输出：1

解释：

nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。

nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。

因此，返回 1 。

示例 3：

输入：nums = [3,2,1]

输出：3

解释：

nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。

nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。

因此，返回 3 。



提示：

1 <= nums.length <= 50
1 <= nums[i] <= 50
 */
public class Q1 {
    public static void main(String[] args) {
        int[] nums = {1,9,7,1};
        System.out.println(new Q1().longestMonotonicSubarray(nums));
    }

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        // 定义dp_i[i]为nums中以i结尾的最长递增子数组
        int[] dp_i = new int[n];
        // 定义dp_d[i]为nums中以i结尾的最长递减子数组
        int[] dp_d = new int[n];

        // base case
        for (int i = 0; i < n; i++) {
            dp_i[i] = 1;
            dp_d[i] = 1;
        }

        // 状态转移函数
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                // 如果当前数字大于前面的数字，则最长递增子数组在前面的基础上+1
                dp_i[i] = dp_i[i-1] + dp_i[i];
            } else if (nums[i] == nums[i-1]) {
                dp_i[i] = 1;
                dp_d[i] = 1;
            } else {
                dp_d[i] = dp_d[i-1] + dp_d[i];
            }
        }

        int dp_i_max = Integer.MIN_VALUE;
        int dp_d_max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_max = Math.max(dp_i_max, dp_i[i]);
            dp_d_max = Math.max(dp_d_max, dp_d[i]);
        }

        return Math.max(dp_d_max, dp_i_max);
    }


}