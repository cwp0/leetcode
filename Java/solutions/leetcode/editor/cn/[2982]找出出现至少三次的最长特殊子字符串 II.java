// 
// @Question: [2982]找出出现至少三次的最长特殊子字符串 II 
// @Author: cwp0
// @CreatedTime: 2024-05-30 10:25:51
// @Description: 
//给你一个仅由小写英文字母组成的字符串 s 。 
//
// 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
//符串。 
//
// 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。 
//
// 子字符串 是字符串中的一个连续 非空 字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaaa"
//输出：2
//解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
//可以证明最大长度是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcdef"
//输出：-1
//解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcaba"
//输出：1
//解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
//可以证明最大长度是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 * 10⁵ 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 二分查找 计数 滑动窗口 👍 16 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int res = -1;

        List<Integer>[] chars = new List[26];
        for (int i = 0 ; i < 26; i++) {
            chars[i] = new ArrayList<>();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            if (i + 1 == n || s.charAt(i) != s.charAt(i+1)) {
                int ch = s.charAt(i) - 'a';
                chars[ch].add(count);
                count = 0;

                for (int j = chars[ch].size() - 1; j > 0; j--) {
                    if (chars[ch].get(j) > chars[ch].get(j-1)) {
                        Collections.swap(chars[ch], j, j-1);
                    } else {
                        break;
                    }
                }

                if (chars[ch].size() > 3) {
                    chars[ch].remove(chars[ch].size() - 1);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i].size() > 0 && chars[i].get(0) - 2 > 0) {
                res = Math.max(res, chars[i].get(0) - 2);
            }
            if (chars[i].size() > 1 && chars[i].get(0) - 1 > 0) {
                res = Math.max(res, Math.min(chars[i].get(0) - 1, chars[i].get(1)));
            }
            if (chars[i].size() > 2) {
                res = Math.max(res, chars[i].get(2));
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
