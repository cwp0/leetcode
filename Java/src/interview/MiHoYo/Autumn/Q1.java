package interview.MiHoYo.Autumn;

/**
 * @Program: Java
 * @Package: interview.MiHoYo.Autumn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 16:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    static int landId = 2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }





    }


}