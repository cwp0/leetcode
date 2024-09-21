package interview.TongCheng58;

/**
 * @Program: Java
 * @Package: interview.TongCheng58
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/20 19:12
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return int整型
     */
    public int StringSplit (String str) {
        // write code here
        int n = str.length();
        int res = 0;

        int[] leftA = new int[n];
        int[] rightB = new int[n];

        leftA[0] = str.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < n-1; i++) {
            leftA[i] = leftA[i-1] + (str.charAt(i) == 'a' ? 1 : 0);
        }

        rightB[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightB[i] = rightB[i+1] + (str.charAt(i) == 'b' ? 1 : 0);
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, leftA[i] + rightB[i]);
        }

        return res;
    }

}