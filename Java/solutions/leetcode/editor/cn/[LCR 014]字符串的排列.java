// 
// @Question: [LCR 014]字符串的排列 
// @Author: cwp0
// @CreatedTime: 2024-04-09 22:26:02
// @Description: 
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
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
// 
//
// 
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 107 👎 0

import java.util.HashMap;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        // 记录字符串s1中每个字符的出现次数
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            // 增大窗口
            right++;
            // 增大窗口后的数据处理
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 是否可以缩小窗口
            while (right - left == s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 缩小窗口后的数据处理
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
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
