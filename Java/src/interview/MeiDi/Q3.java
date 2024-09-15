package interview.MeiDi;

/**
 * @Program: Java
 * @Package: interview.MeiDi
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/15 14:40
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    static int x;
    static int y;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[x][y];
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '0' && !visited[i][j]) {
                    if (!isConnectedToNe(grid,visited, i, j)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }

    // DFS搜索判断区域是是否与边界相连
    static boolean isConnectedToNe(char[][] grid, boolean[][] visited, int i, int j) {
        boolean isBoundaryConnected = false; // 是否与边界相连
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curX = current[0];
            int curY = current[1];

            if (curX == 0 || curX == x-1 || curY == 0 || curY == y-1) {
                isBoundaryConnected = true;
            }

            for (int[] direction : directions) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (newX >= 0 && newX < x && newY >= 0 && newY < y && grid[newX][newY] =='0' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new int[]{newX, newY});
                }
            }
        }
        return isBoundaryConnected;
    }

}