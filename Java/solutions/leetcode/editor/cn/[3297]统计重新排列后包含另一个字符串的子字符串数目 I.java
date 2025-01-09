// 
// @Question: [3297]统计重新排列后包含另一个字符串的子字符串数目 I 
// @Author: cwp0
// @CreatedTime: 2025-01-09 12:58:31
// @Description: 
//给你两个字符串 word1 和 word2 。 
//
// 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。 
//
// 请你返回 word1 中 合法 子字符串 的数目。 
//
// 
//
// 示例 1： 
//
// 
// 输入：word1 = "bcca", word2 = "abc" 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。 
//
// 示例 2： 
//
// 
// 输入：word1 = "abcabc", word2 = "abc" 
// 
//
// 输出：10 
//
// 解释： 
//
// 除了长度为 1 和 2 的所有子字符串都是合法的。 
//
// 示例 3： 
//
// 
// 输入：word1 = "abcabc", word2 = "aaabc" 
// 
//
// 输出：0 
//
// 
//
// 解释： 
//
// 
// 1 <= word1.length <= 10⁵ 
// 1 <= word2.length <= 10⁴ 
// word1 和 word2 都只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 17 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long validSubstringCount(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] diff = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
        for (char c : t) {
            diff[c - 'a']++;
        }

        // 统计窗口内有多少个字母的出现次数比 t 的少
        int less = 0;
        for (int d : diff) {
            if (d > 0) {
                less++;
            }
        }

        long ans = 0;
        int left = 0;
        for (char c : s) {
            diff[c - 'a']--;
            if (diff[c - 'a'] == 0) {
                // c 移入窗口后，窗口内 c 的出现次数和 t 的一样
                less--;
            }
            while (less == 0) { // 窗口符合要求
                char outChar = s[left++]; // 准备移出窗口的字母
                if (diff[outChar - 'a'] == 0) {
                    // outChar 移出窗口之前检查出现次数，
                    // 如果窗口内 outChar 的出现次数和 t 的一样，
                    // 那么 outChar 移出窗口后，窗口内 outChar 的出现次数比 t 的少
                    less++;
                }
                diff[outChar - 'a']++;
            }
            ans += left;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

