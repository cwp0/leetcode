// 
// @Question: [3]无重复字符的最长子串 
// @Author: cwp0
// @CreatedTime: 2024-04-09 22:21:33
// @Description: 
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10085 👎 0

import java.util.HashMap;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 窗口变化后对数据进行处理
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 是否可以缩小窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 窗口变化后对数据进行处理
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
