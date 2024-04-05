// 
// @Question: [1312]让字符串成为回文串的最少插入次数 
// @Author: cwp0
// @CreatedTime: 2024-04-04 19:17:48
// @Description: 
//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
//
// Related Topics 字符串 动态规划 👍 237 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        // 定义dp[i][j]为s[i..j]，最少需要插入dp[i][j]次才能变为回文串
        int[][] dp = new int[n][n];

        // base case
        // 对于每个字符本身，需要插入的次数为0，就可以让其变为一个回文串
        // 对于i>j的情况，没有子串，全部为0


        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // 状态转移函数
                // 如果s在i处的字符和s在j处的字符相等，那么不需要插入，此时dp[i][j] = dp[i+1][j-1]
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    // 如果不相等，那么说明s在i处的字符需要在另一侧被插入，或者s在j处的字符需要在另一侧被插入，比较最小值
                    dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i+1][j] + 1);
                }
            }
        }

        // 所求答案
        return dp[0][n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
