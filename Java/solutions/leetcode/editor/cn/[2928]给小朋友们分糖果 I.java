// 
// @Question: [2928]给小朋友们分糖果 I 
// @Author: cwp0
// @CreatedTime: 2024-06-01 22:23:27
// @Description: 
//给你两个正整数 n 和 limit 。 
//
// 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, limit = 2
//输出：3
//解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, limit = 3
//输出：10
//解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3,
// 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 1 <= limit <= 50 
// 
//
// Related Topics 数学 组合数学 枚举 👍 54 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distributeCandies(int n, int limit) {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1);
    }

    private int c2(int n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
