package interview;

/**
 * @Program: Java
 * @Package: interview
 * @Class: TencentWXG
 * @Description: 腾讯-WXG-移动客户端开发 基础微信&视频号团队 面试手撕
 * @Author: cwp0
 * @CreatedTime: 2024/03/20 13:23
 * @Version: 1.0
 */
public class TencentWXG {
    public static void main(String[] args) {
        // 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

        System.out.println(isContainHuiWen("aba"));

    }

    public static String func(String s) {
        String res = s;

        return res;

    }

    public static boolean isContainHuiWen(String s) {

        int len = s.length();

        for(int i = 0; i < len/2; i ++) {
            if(s.charAt(i) != s.charAt(len-1-i)) {
                return false;
            }
        }

        return true;
    }
}