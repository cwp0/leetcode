package interview.pinduoduo;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: interview.pinduoduo.Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/24 20:15
 * @Version: 1.0
 */
public class Q4 {
    /*
    多多有一个长度为 n 的字符串, 这个字符串由26个小写字母组成.
    多多可以对这个字符串进行多次操作, 每次操作可以把该字符串中一段连续的回文子串删除(单个字符也属于回文串), 删除后剩下的串会拼在一起.
    请问最少需要多少次操作可以将这个字符串删光.

    输入描述：
    第一行, 包含一个正整数 T( 1 \leq T \leq 20) 代表测试数据的组数.
    对于每组测试数据, 仅有一行, 代表这个字符串.
    ( 1 \leq n \leq 500)
    保证 \sumn 不超过 3000

    输出描述：
    对于每组数据输出一行整数, 代表多多在进行最少多少次操作后, 可以将这个字符串删光.

    例子
    输入：
    3
    mwapd
    tvuvv
    yxxmi

    输出：
    5
    3
    4

    说明：
    对于 tvuvv
    第一步: 删除u, 此时剩下tvvv
    第二步: 删除vvv, 此时剩下t
    第三步: 删除t
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            System.out.println(getMin(s));
        }
    }

    public static int getMin(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }


}