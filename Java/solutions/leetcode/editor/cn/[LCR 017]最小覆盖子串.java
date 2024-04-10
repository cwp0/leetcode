// 
// @Question: [LCR 017]最小覆盖子串 
// @Author: cwp0
// @CreatedTime: 2024-04-09 22:25:11
// @Description: 
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 119 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        // 滑动窗口
        // 记录滑动窗口中每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();
        // 记录字符串t中所有字符的出现次数
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口的左右边界
        int left = 0, right = 0;
        // 滑动窗口中window的合法字符个数
        int valid = 0;
        // s中包含t的所有字符的最短子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 处理窗口扩大后的数据
            // 如果need中包含字符c
            if (need.containsKey(c)) {
                // 先把字符c及出现次数加入window中
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只有need中字符c的的次数等于window中字符c的次数，才是合法字符
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 左边界什么时候要缩小
            // 在合法字符数量等于need的尺寸时
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                // 窗口左边界缩小
                left++;
                // 处理边界缩小后的数据
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
