package interview.HW;

/**
 * @Program: Java
 * @Package: interview.HW
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/14 20:56
 * @Version: 1.0
 */
public class Q2 {
    static int M, N;
    static int count = 0;

    // 使用数组记录哪些列、主对角线、副对角线已经被占用
    static boolean[] Cols;
    static boolean[] Line1; // 左上到右下
    static boolean[] Line2; // 右上到左下

    public static void main(String[] args) {
        // 读取输入
        java.util.Scanner sc = new java.util.Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        // 初始化数组
        Cols = new boolean[N]; // 标记每一列是否已使用
        Line1 = new boolean[M + N - 1]; // 标记每条主对角线是否已使用
        Line2 = new boolean[M + N - 1]; // 标记每条副对角线是否已使用

        // 开始回溯
        backtrack(0);

        // 输出结果
        System.out.println(count);
    }

    // 回溯函数，尝试在第 row 行安装监控器
    static void backtrack(int row) {
        if (row == M) {
            // 已经处理了所有的行，说明找到了一种合法的方案
            count++;
            return;
        }

        // 遍历当前行的所有列
        for (int col = 0; col < N; col++) {
            // 检查当前列和对角线是否已被占用
            if (Cols[col] || Line1[row - col + N - 1] || Line2[row + col]) {
                continue; // 如果当前选择不合法，跳过
            }

            // 标记当前列和对角线为已使用
            Cols[col] = true;
            Line1[row - col + N - 1] = true;
            Line2[row + col] = true;

            // 递归尝试放置下一个行的监控器
            backtrack(row + 1);

            // 回溯，撤销选择
            Cols[col] = false;
            Line1[row - col + N - 1] = false;
            Line2[row + col] = false;
        }
    }
}


/*

Java ACM模式解题
数据中心摆放M排N列机柜，现需要在每排选择一个机柜安装监控器来监视本排机柜的用电量，由于监控器安装位置太近的话会相互干扰，安装时候需要满足条件：
安装监控器的机柜不能在同一排或者同一列，并且不能在同一斜线上(45°或者135°的正斜线)。请问一共有多少种安装监控器的方案？

输入描述
机柜的行数M和列数N(1<=M,N<15)

输出描述
输出一行一个整数表示方案数，如果没有方案则输出0

样例输入
2 3
样例输出
2
说明
有两种安装方案
1 0 0
0 0 1

0 0 1
1 0 0

其中，1表示安装监控器的机柜，0表示未安装监控器的机柜

*/
