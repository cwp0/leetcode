// 
// @Question: [76]最小覆盖子串 
// @Author: cwp0
// @CreatedTime: 2024-04-09 22:22:33
// @Description: 
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2876 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        // 滑动窗口 中的窗口
        Map<Character, Integer> window = new HashMap<>();
        // 记录 t 中字符出现的次数
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口的左右边界
        int left = 0, right = 0;
        // 记录window窗口中与t字符串中字符数量匹配的合法字符数量
        int valid = 0;
        // 记录s中涵盖t所有字符的最小子串的起始索引和长度(左闭右开)
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);

            // 扩大窗口
            right++;
            // 对窗口里的数据进行更新
            // 如果字符c被包含在need中
            if (need.containsKey(c)) {
                // 先将c出现的次数加入到窗口window中
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果need中出现c的次数和window中出现c的次数相等，则合法字符数量+1
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 判断滑动窗口的左侧是否要收缩
            // 合法字符数量和need中的字符数量相等，则要收缩
            while (valid == need.size()) {
                if (right - left < len) { // 在这里就已经是左闭右开
                    start = left;
                    len = right - left; // 所以这里也是左闭右开
                }
                // 字符d是即将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口，注意是++
                left++;
                // 对窗口内的数据进行更新
                // 如果字符d被包含在need中
                if (need.containsKey(d)) {
                    // 如果need中出现d的次数和window中出现d的次数相等，则合法字符数量-1
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    // 将d出现的次数从window中减去
                    window.put(d, window.get(d) - 1);
                }

            }

        }
        // 注意substring[开始字符索引, 结束字符索引),第二个参数不是子串长度。
        return len==Integer.MAX_VALUE ? "" : s.substring(start, start + len); // 这里直接就是左闭右开

    }
}
//leetcode submit region end(Prohibit modification and deletion)
