// 
// @Question: [3292]形成目标字符串需要的最少字符串数 II 
// @Author: cwp0
// @CreatedTime: 2024-12-18 13:51:00
// @Description: 
//给你一个字符串数组 words 和一个字符串 target。 
//
// 如果字符串 x 是 words 中 任意 字符串的 前缀，则认为 x 是一个 有效 字符串。 
//
// 现计划通过 连接 有效字符串形成 target ，请你计算并返回需要连接的 最少 字符串数量。如果无法通过这种方式形成 target，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 
// 输入： words = ["abc","aaaaa","bcdef"], target = "aabcdabc" 
// 
//
// 输出： 3 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[1] 的长度为 2 的前缀，即 "aa"。 
// words[2] 的长度为 3 的前缀，即 "bcd"。 
// words[0] 的长度为 3 的前缀，即 "abc"。 
// 
//
// 示例 2： 
//
// 
// 输入： words = ["abababab","ab"], target = "ababaababa" 
// 
//
// 输出： 2 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// 
//
// 示例 3： 
//
// 
// 输入： words = ["abcdef"], target = "xyz" 
// 
//
// 输出： -1 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 5 * 10⁴ 
// 输入确保 sum(words[i].length) <= 10⁵. 
// words[i] 只包含小写英文字母。 
// 1 <= target.length <= 5 * 10⁴ 
// target 只包含小写英文字母。 
// 
//
// Related Topics 线段树 数组 字符串 二分查找 动态规划 字符串匹配 哈希函数 滚动哈希 👍 27 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] back = new int[n];
        for (String word : words) {
            int[] pi = prefixFunction(word, target);
            int m = word.length();
            for (int i = 0; i < n; i++) {
                back[i] = Math.max(back[i], pi[m + 1 + i]);
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, n + 1, (int) 1e9);
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i + 1 - back[i]] + 1;
            if (dp[i + 1] > n) {
                return -1;
            }
        }
        return dp[n];
    }

    private int[] prefixFunction(String word, String target) {
        String s = word + "#" + target;
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

