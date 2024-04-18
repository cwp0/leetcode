package interview.ALiGuoJi;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.ALiGuoJi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/18 21:01
 * @Version: 1.0
 */
public class Q2 {
    /*
    定义一个好数为当且仅当x被他的数位和整除。即x % digit_sum(x) = 0。例如123的数位和为1 + 2 +3 = 6.

    现在给定一个数字n，求n最少被表示成几个好数的和。


    输入T+1行
    第一行一个整数T（1<=T<=10^4）表示测试数据的组数
    接下来T行，每行一个正整数n(1<=x<=2 * 10^5)

    输出
    输出T行，每行一个正整数表示每个测试数据的答案。
     */
    private static final int MAX_N = 200000;

    // 计算一个数字的数位和
    private static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    // 判断一个数字是否是好数
    private static boolean isGoodNumber(int x) {
        int sum = digitSum(x);
        return x % sum == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取测试数据组数
        int T = scanner.nextInt();

        // 收集所有好数
        List<Integer> goodNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_N; i++) {
            if (isGoodNumber(i)) {
                goodNumbers.add(i);
            }
        }

        // 处理每个测试数据
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(minGoodNumbersToReach(n, goodNumbers));
        }

        scanner.close();
    }

    // 通过广度优先搜索计算最少的好数组合以达到 n
    private static int minGoodNumbersToReach(int n, List<Integer> goodNumbers) {
        // 队列用于广度优先搜索
        Queue<int[]> queue = new LinkedList<>();
        // 标记数组，用于记录已访问的值
        boolean[] visited = new boolean[n + 1];

        // 初始化队列，从值为0开始
        queue.offer(new int[] {0, 0}); // {当前值, 当前步数}
        visited[0] = true;

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            // 遍历所有好数
            for (int goodNumber : goodNumbers) {
                int newValue = value + goodNumber;

                // 如果新值等于 n，则找到了最小步数
                if (newValue == n) {
                    return steps + 1;
                }

                // 如果新值小于 n 且未访问过，则将其加入队列
                if (newValue <= n && !visited[newValue]) {
                    visited[newValue] = true;
                    queue.offer(new int[] {newValue, steps + 1});
                }
            }
        }

        // 如果找不到解返回一个特殊的错误值
        return -1;
    }
}
