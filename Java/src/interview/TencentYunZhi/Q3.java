package interview.TencentYunZhi;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/07/02 20:17
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(count(s));
    }

    private static int count(String s) {
        int n = s.length();
        int res = 0;
        int left = 0;
        int lastR = -1; // 记录最后一个r 的位置
        int lastE = -1; // 记录最后一个 e 的位置
        // 滑动窗口
        for (int right = 0; right < n; right ++) {
            char c = s.charAt(right);

            if (c == 'd') {
                left = right + 1; // 遇到d 的话，左边界移到 d 的右边
                // 重置 r 和 e 的位置
                lastR = -1;
                lastE = -1;
            } else {
                if (c == 'r') lastR = right;
                if (c == 'e') lastE = right;

                if (lastR != -1 && lastE != -1) { // 不包含 d，且包含 r 和 e
                    int minPos = Math.min(lastR, lastE);
                    // 计算符合条件的子串个数
                    res += (minPos - left + 1);
                }
            }
        }
        return res;
    }

}