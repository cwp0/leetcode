// 
// @Question: [516]最长回文子序列 
// @Author: cwp0
// @CreatedTime: 2024-04-04 19:17:54
// @Description: 
//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1191 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // 定义dp[i][j]为 s[i..j]之间的最长回文子序列
        int[][] dp = new int[n][n];
        // base case
        // 每个字符处，最长回文子序列为其本身，长度1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // i > j处，不存在子序列，全部为0

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // 状态转移函数
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果s在i处的字符和s在j处的字符相等，则两字符同时加入dp[i+1][j-1],长度+2
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    // 如果不相等，则两字符不能同时出现在最长回文子序列中，把两个字符都加入，看看哪个更长
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }

            }
        }


        return dp[0][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
