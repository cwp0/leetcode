package autumn.JingDongTET;

/**
 * @Program: Java
 * @Package: autumn.JingDongTET
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/30 19:09
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int frontArea = 0;
        for (int j = 0; j < m; j++) {
            int maxH = 0;
            for (int i = 0; i < n; i++) {
                maxH = Math.max(maxH, matrix[i][j]);
            }
            frontArea += maxH;
        }

        int leftArea = 0;
        for (int i = 0; i < n; i++) {
            int maxH = 0;
            for (int j = 0; j < m; j++) {
                maxH = Math.max(maxH, matrix[i][j]);
            }
            leftArea += maxH;
        }

        int topArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0) {
                    topArea++;
                }
            }
        }

        System.out.println(frontArea + " " + leftArea + " " + topArea);

    }
}