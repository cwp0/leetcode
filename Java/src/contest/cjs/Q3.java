package contest.cjs;

import java.util.*;

/**
 * @Program: Java
 * @Package: contest.cjs
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 10:59
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的字符串 S 和 T
        String S = scanner.nextLine();
        String T = scanner.nextLine();

        // 读取询问次数 q
        int q = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 处理每一次询问
        for (int i = 0; i < q; i++) {
            // 读取询问的四个整数 a, b, c, d
            String[] input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1; // 转换为从 0 开始的索引
            int b = Integer.parseInt(input[1]) - 1;
            int c = Integer.parseInt(input[2]) - 1;
            int d = Integer.parseInt(input[3]) - 1;

            // 判断两段子串是否等价
            String subS = S.substring(a, b + 1);
            String subT = T.substring(c, d + 1);
            if (isEquivalent(subS, subT)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    public static boolean isEquivalent(String subS, String subT) {

        while (!subS.equals(subT)) {
            if (subS.contains("XXX")) {
                subS = subS.replace("XXX", "");
            }
            if (subS.contains("HHH")) {
                subS = subS.replace("HHH", "");
            }
            if (subS.contains("XX")) {
                subS = subS.replace("XX", "H");
            }
            if (subS.contains("HH")) {
                subS = subS.replace("HH", "X");
            }
        }


        // 使用递归判断是否相等
        return subS.equals(subT);
    }


}