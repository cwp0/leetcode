// 
// @Question: [567]字符串的排列 
// @Author: cwp0
// @CreatedTime: 2024-04-09 22:22:17
// @Description: 
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 998 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            // 扩大窗口
            right++;
            // 处理窗口扩大后的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 是否需要缩小窗口
            // 这里维护了一个跟s1的大小相等的滑动窗口
            // 把while换成if
            if (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 处理窗口缩小后的数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
