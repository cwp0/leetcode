package interview.ALiGuoJi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.ALiGuoJi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/18 21:01
 * @Version: 1.0
 */
public class Q1 {
    /*
    一个n*n的矩阵，其中若干格子被染成了黑色，现在画一些正斜线和反斜线(共有2n-1条正斜线和2n-1条反斜线)。正斜线从右上到左下，反斜线从左上到右下。

    输入第一行n m分别表示矩阵的大小和m个格子被染成黑色。
    接下来m行，每行输入两个正整数x，y代表第x行 y列的格子被染成黑色
    1<=m<=10^5
    1<=n<=10^9
    1<=x, y<=n

    输出两个整数，分别代表经过黑色格子的正斜线和反斜线数量
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 用HashSet来保存经过黑色格子的正斜线和反斜线的编号
        HashSet<Integer> positiveDiagonals = new HashSet<>();
        HashSet<Integer> negativeDiagonals = new HashSet<>();

        // 读取m个染成黑色的格子
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // 计算正斜线编号 (x - y)
            int diag1 = x - y;
            // 计算反斜线编号 (x + y)
            int diag2 = x + y;

            // 将编号添加到集合中
            positiveDiagonals.add(diag1);
            negativeDiagonals.add(diag2);
        }

        // 输出结果
        System.out.println(positiveDiagonals.size() + " " + negativeDiagonals.size());
    }
}
