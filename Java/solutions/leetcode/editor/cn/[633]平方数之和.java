// 
// @Question: [633]平方数之和 
// @Author: cwp0
// @CreatedTime: 2024-11-04 13:30:10
// @Description: 
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
//
// Related Topics 数学 双指针 二分查找 👍 482 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
