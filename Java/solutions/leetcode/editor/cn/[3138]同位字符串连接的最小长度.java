// 
// @Question: [3138]同位字符串连接的最小长度 
// @Author: cwp0
// @CreatedTime: 2024-12-20 13:21:01
// @Description: 
//给你一个字符串 s ，它由某个字符串 t 和若干 t 的 同位字符串 连接而成。 
//
// 请你返回字符串 t 的 最小 可能长度。 
//
// 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "abba" 
// 
//
// 输出：2 
//
// 解释： 
//
// 一个可能的字符串 t 为 "ba" 。 
//
// 示例 2： 
//
// 
// 输入：s = "cdef" 
// 
//
// 输出：4 
//
// 解释： 
//
// 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 27 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAnagramLength(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        next:
        for (int k = 1; k <= n / 2; k++) {
            if (n % k > 0) {
                continue;
            }
            int[] cnt0 = new int[26];
            for (int j = 0; j < k; j++) {
                cnt0[s[j] - 'a']++;
            }
            for (int i = k * 2; i <= n; i += k) {
                int[] cnt = new int[26];
                for (int j = i - k; j < i; j++) {
                    cnt[s[j] - 'a']++;
                }
                if (!Arrays.equals(cnt, cnt0)) {
                    continue next;
                }
            }
            return k;
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

