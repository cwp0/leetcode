// 
// @Question: [1702]修改后的最大二进制字符串 
// @Author: cwp0
// @CreatedTime: 2024-04-10 16:06:26
// @Description: 
//给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改： 
//
// 
// 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。 
// 
//
// 
// 比方说， "00010" -> "10010" 
// 
// 
// 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
// 
// 比方说， "00010" -> "00001" 
// 
// 
//
//
// 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制
//字符串 x 大于二进制字符串 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：binary = "000110"
//输出："111011"
//解释：一个可行的转换为：
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// 示例 2： 
//
// 
//输入：binary = "01"
//输出："01"
//解释："01" 没办法进行任何转换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary 仅包含 '0' 和 '1' 。 
// 
//
// Related Topics 贪心 字符串 👍 68 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumBinaryString(String binary) {
        // 寻找第一个0的索引
        int i = binary.indexOf("0");
        // 如果索引小于0说明没找到0，binary中全是1，直接返回binary
        if (i < 0) {
            return binary;
        }

        char[] s = binary.toCharArray();
        // 从i到n-1中有多少个1
        int count1 = 0;
        for (i++; i < s.length; i++) {
            count1 += s[i] - '0';
        }
        // 结果由 n-1-count1个1 + 1个0 + count1个1 组成
        char[] res = new char[s.length];
        Arrays.fill(res, '1');
        res[s.length-count1-1] = '0';
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
