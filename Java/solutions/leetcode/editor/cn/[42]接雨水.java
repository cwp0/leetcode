// 
// @Question: [42]接雨水 
// @Author: cwp0
// @CreatedTime: 2024-06-29 18:30:42
// @Description: 
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5201 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int res = 0;
        // 备忘录记录每个位置左右柱子高度的最大值
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];
        // 从左到右计算l_max
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i-1]);
        }
        // 从右往左计算r_max
        for (int i = n-2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i+1]);
        }
        // 计算答案
        for (int i = 1; i < n-1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
