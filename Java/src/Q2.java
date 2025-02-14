/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/19 11:31
 * @Version: 1.0
 */

/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"


提示：
1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300]
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        System.out.println(decode("10[a]"));
//        System.out.println(decode("3[a]2[bc]"));
//        System.out.println(decode("2[abc]3[cd]ef"));
//        System.out.println(decode("abc3[cd]xyz"));
    }
    public static String decode(String s) {
        StringBuilder res = new StringBuilder();

        Stack<Integer> num_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();

        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                 num = num * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                num_stack.push(num);
                str_stack.push(res.toString());

                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int cur_num = num_stack.peek();
                num_stack.pop();
                String last_str = str_stack.peek();
                str_stack.pop();

                for (int i = 0; i < cur_num; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(last_str + temp);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}