package interview.ALiGuoJi;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.ALiGuoJi
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/18 21:01
 * @Version: 1.0
 */
public class Q3 {
    /*
    有一个数字x和y，y比x大，希望进行如下三种操作
    x = x+2 花费c1
    x = x - 3花费c2
    x = x+5 花费c3

    问将x变为和y相等，最少要花费多少

    输入
    T+1行，第一行一个正整数T（1<=T<=10^3），表示数据组数。

    接下来T行，每行5个整数x ,y,c1,c2,c3（0<=x<=y<=10^16, 1<=ci<=10）分别表示x，y的初始值，以及每种操作的代价。

    输出
    T行，每行一个正整数表示最小花费
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取测试数据组数
        int T = scanner.nextInt();

        // 处理每个测试数据
        for (int i = 0; i < T; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            int c3 = scanner.nextInt();

            // 计算最小花费
            long minCost = calculateMinCost(x, y, c1, c2, c3);
            System.out.println(minCost);
        }

        scanner.close();
    }

    // 使用广度优先搜索（BFS）计算从 x 到 y 的最小花费
    private static long calculateMinCost(long x, long y, int c1, int c2, int c3) {
        // 使用一个优先级队列来实现广度优先搜索
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(arr -> arr[1]));
        // 使用HashSet来标记访问过的值
        Set<Long> visited = new HashSet<>();

        // 将初始状态加入队列
        queue.offer(new long[] {x, 0});
        visited.add(x);

        // 广度优先搜索
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long value = current[0];
            long cost = current[1];

            // 如果当前值等于目标值y，则返回当前成本
            if (value == y) {
                return cost;
            }

            // 尝试三种操作
            long[] operations = {
                    value + 2,
                    value - 3,
                    value + 5
            };
            int[] costs = {
                    c1,
                    c2,
                    c3
            };

            // 遍历三种操作
            for (int i = 0; i < 3; i++) {
                long newValue = operations[i];
                long newCost = cost + costs[i];

                // 如果新值在目标范围内并且未访问过，加入队列
                if (newValue <= y && visited.add(newValue)) {
                    queue.offer(new long[] {newValue, newCost});
                }
            }
        }

        // 如果没有找到解决方案，返回一个特殊的错误值
        return -1;
    }
}
