// 
// @Question: [LCR 095]最长公共子序列 
// @Author: cwp0
// @CreatedTime: 2024-04-03 19:58:25
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
// 
//
// 
// 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-
//subsequence/ 
//
// Related Topics 字符串 动态规划 👍 159 👎 0

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

    // 定义dp(s1, i, s2, j) 为si[i..] 和s2[j..]的最长公共子序列长度
    private int dp(String s1, int i, String s2, int j) {
        // base case
        // 如果i或者j在最尾部，空字符串与任何字符串的最长公共子序列长度都为0
        if (i == s1.length() || j == s2.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int res = 0;
        // 状态转移函数
        if (s1.charAt(i) == s2.charAt(j)) {
            res = dp(s1, i+1, s2, j+1) + 1;
        } else {
            // 三种情况
            // 1 s1在i处的字符不属于最长公共子序列，但s2在j处的字符属于最长公共子序列
            // 2 s1在i处的字符属于最长公共子序列，但s2在j处的字符不属于最长公共子序列
            // 3 都不属于最长公共子序列
            res = Math.max(dp(s1, i+1, s2, j), dp(s1, i, s2, j+1));
//            res = Math.max(res, dp(s1, i+1, s2, j+1));
        }
        memo[i][j] = res;
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
