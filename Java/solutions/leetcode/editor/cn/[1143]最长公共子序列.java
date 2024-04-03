// 
// @Question: [1143]最长公共子序列 
// @Author: cwp0
// @CreatedTime: 2024-04-03 13:55:24
// @Description: 
//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// Related Topics 字符串 动态规划 👍 1538 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 备忘录
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {

        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(text1, 0, text2, 0);
    }


    // 定义dp函数为s1[i..]和s2[j..]的最长公共子序列，那么所求结果就是dp[s1, 0, s2, 0]。
    private int dp(String s1, int i, String s2, int j) {

        // base case
        // 相当于s1或者s2的结尾空字符串，那么其长度为0
        if (i == s1.length() || j == s2.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int res = 0;
        // 状态转移函数
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果s1[i]处的字符和s2[j]处的字符相等，那么这个字符肯定在最长公共子序列中
            memo[i][j] =  1 + dp(s1, i+1, s2, j+1);
        } else {
            // 如果s1[i]处的字符和s2[j]处的字符不相等
            // 1. s1[i] 不在最长公共子序列中
            // 2. s2[j] 不在最长公共子序列中
            // 3. 都不在最长公共子序列中 dp(s1, i+1, s2, j+1) 这种情况包含于前两种情况。
            memo[i][j] = Math.max(dp(s1, i, s2, j+1), dp(s1, i+1, s2, j));
        }
        return memo[i][j];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
