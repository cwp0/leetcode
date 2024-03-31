package contest.cjs;

import java.util.*;

/**
 * @Program: Java
 * @Package: contest.cjs
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 09:54
 * @Version: 1.0
 */

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取知识点字符串和整数 K
        String s = scanner.nextLine();
        int K = scanner.nextInt();

        // 计算所有可能的套题知识点并输出第 K 简单的套题知识点
        int count = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                count++;
                if (count == K) {
                    result = s.substring(i, j);
                    break;
                }
            }
            if (!result.isEmpty()) {
                break;
            }
        }

        System.out.println(result);

        scanner.close();
    }
}
