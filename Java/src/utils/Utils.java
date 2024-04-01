package utils;

/**
 * @Program: Java
 * @Package: utils
 * @Class: Utils
 * @Description: 工具函数
 * @Author: cwp0
 * @CreatedTime: 2024/04/01 23:15
 * @Version: 1.0
 */
public class Utils {

    public static void main(String[] args) {
        System.out.println(reverseStr("apple"));
        System.out.println(reverseStr1("apple"));

    }

    /**
     * @Description: 反转字符串
     * @Param: str      {java.lang.String}
     * @Return: java.lang.String
     * @Author: cwp0
     * @CreatedTime: 2024/4/1 23:16
     */
    private static String reverseStr(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = str.length()-1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * @Description: 反转字符串
     * @Param: str      {java.lang.String}
     * @Return: java.lang.String
     * @Author: cwp0
     * @CreatedTime: 2024/4/1 23:17
     */
    private static String reverseStr1(String str) {
        int len = str.length();
        StringBuilder res = new StringBuilder(str.length());
        for (int i = len - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            res.append(ch);
        }
        return res.toString();
    }

    /**
     * @Description: 返回回文子串
     * @Param: str      {java.lang.String}
     * @Return: java.lang.String
     * @Author: cwp0
     * @CreatedTime: 2024/4/1 23:18
     */
    private static String findHuiWen(String str) {

        return null;
    }
}