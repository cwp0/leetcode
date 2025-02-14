package interview.HW;

/**
 * @Program: Java
 * @Package: interview.HW
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/14 20:56
 * @Version: 1.0
 */
import java.util.*;

public class Q3 {
    // 定义四个方向的移动（上下左右）
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int M = scanner.nextInt();
        scanner.nextLine();  // 读取换行符

        char[][] grid = new char[M][M];
        int XX = -1, XY = -1, BX = -1, BY = -1, GX = -1, GY = -1;

        for (int i = 0; i < M; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = line[j].charAt(0);
                if (grid[i][j] == 'X') {
                    XX = i;
                    XY = j;
                } else if (grid[i][j] == 'B') {
                    BX = i;
                    BY = j;
                } else if (grid[i][j] == 'G') {
                    GX = i;
                    GY = j;
                }
            }
        }

        // 使用BFS搜索
        int result = bfs(grid, M, XX, XY, BX, BY, GX, GY);
        System.out.println(result);
    }

    static int bfs(char[][] grid, int M, int XX, int XY, int BX, int BY, int GX, int GY) {
        // 队列保存的是 (小明x, 小明y, 球x, 球y, 踢球次数)
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 初始状态加入队列
        queue.offer(new int[] {XX, XY, BX, BY, 0});
        visited.add(XX + "," + XY + "," + BX + "," + BY);

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int xx = state[0], xy = state[1], bx = state[2], by = state[3], kicks = state[4];

            // 如果球已经到达球门
            if (bx == GX && by == GY) {
                return kicks;
            }

            // 小明可以向四个方向移动
            for (int i = 0; i < 4; i++) {
                int newX = xx + dx[i], newY = xy + dy[i];

                // 判断小明的移动是否有效
                if (newX >= 0 && newX < M && newY >= 0 && newY < M && grid[newX][newY] != '1') {
                    // 判断是否与球相邻
                    if (Math.abs(newX - bx) + Math.abs(newY - by) == 1) {
                        // 小明与球相邻，开始踢球
                        int newBX = bx + dx[i], newBY = by + dy[i];

                        // 判断球是否能被踢动
                        if (newBX >= 0 && newBX < M && newBY >= 0 && newBY < M && grid[newBX][newBY] != '1') {
                            // 球能被踢动
                            if (!visited.contains(newX + "," + newY + "," + newBX + "," + newBY)) {
                                visited.add(newX + "," + newY + "," + newBX + "," + newBY);
                                queue.offer(new int[] {newX, newY, newBX, newBY, kicks + 1});
                            }
                        }
                    } else {
                        // 小明移动，不是踢球
                        if (!visited.contains(newX + "," + newY + "," + bx + "," + by)) {
                            visited.add(newX + "," + newY + "," + bx + "," + by);
                            queue.offer(new int[] {newX, newY, bx, by, kicks});
                        }
                    }
                }
            }
        }

        // 如果无法到达球门
        return -1;
    }
}


/*
Java ACM模式解题
小明在一个足球场上踢球，他需要绕过障碍物把球踢到球门里。

足球场用M*M的正方形网格表示，其中每个元素可以是下面的值之一：
X:表示小明，只要他在空地里面，就可以上下左右四个方向移动。
0:表示空地，小明可以自由移动。
1:表示障碍物，意味着不能通行，可能有多个。
B:表示球，小明需要把球踢到球门，只能有一个。
G:表示球门，小明需要把球踢到这里，只能有一个。

初始时候小明和球可能不相邻，他需要走到球的位置才能开始踢球；当移动到球边(相邻格子)后，继续向着球的方向移动，球会被踢到同方向相邻格的位置，即：球移动方向与小明移动方向相同，一次移动一格。
注：如果球移动前方会碰到障碍物或者边界，那么此次踢球无效，小明和球的位置均不变。

小明需要持续移动，直到球被踢进球门，返回小明踢球的最小次数，如果无法踢进，返回-1。
注：足球的每一次移动算作一次踢球，小明自己移动不算踢球。

输入描述：
第一行一个整数M，表示网格的大小。5<=M<=20
接下来M行，每行M个字符，表示网格的元素。仅包含X,0,1,B,G这五种字符，且保证有且仅有一个X，一个B，一个G。

输出描述：
输出一个整数，表示小明踢球的最小次数，如果无法踢进，返回-1。

样例输入
5
0 0 0 0 0
0 0 0 0 G
0 0 B 0 0
X 1 0 0 0
0 0 0 0 0
样例输出
3
 */