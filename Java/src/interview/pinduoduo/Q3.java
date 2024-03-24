package interview.pinduoduo;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: interview.pinduoduo.Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/24 20:07
 * @Version: 1.0
 */
public class Q3 {

    /*
    多多快递站共有n个快递点，n个快递点之间通过m条单向车道连接。快递员从任何一个快递站点出发，都无法通过单向车道回到该站点。 也就是说，n个快递点组成一张有向无环图。对于快递点u，如果对于所有的快递点v (v \neq u)， 快递员都可以从u走到v，或者从v走到u，那么则评定站点u为超级快递点。请你帮忙算一算，一共有多少个超级快递点。

    输入描述：
    第一行 2个数字n ( 2 \leq n \leq 3 * 10^{5} ) , m (1 \leq m \leq 3 * 10^{5}), n为快递点个数，m为单向车道个数。接下来的m行每行两个数字 u,v （1 \leq u,v \leq n, u \neq v），表示有一条站点u指向v的单向车道。

    输出描述：
    请输出1个数字，表示超级快递点的个数。

    例子1
    输入：
    7 7
    1 2
    2 3
    3 4
    4 7
    2 5
    5 4
    6 4

    输出：
    2

    快递点 4 可以到达 4，7，可以从1，2，3，5，6 到达， 评为超级快递点
    快递点 7 可以到达 7，可以从 1，2，3，4，5，6到达，评为超级快递点
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            out[u]++;
            in[v]++;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (in[i] + out[i] == n - 1) {
                count++;
            }
        }
        System.out.println(count);
    }



}