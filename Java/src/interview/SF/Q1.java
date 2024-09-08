package interview.SF;

/**
 * @Program: Java
 * @Package: interview.SF
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 20:36
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        scanner.close();

        int count = 0;
        for (int state = 0; state < (1 << 18); state++) {
            int[][] grid = new int[3][3];
            for (int i = 0; i < 9; i++) {
                grid[i /3][i % 3] = (state >> (i * 2)) & 3;
            }

            int satisfied = 0;
            if ((grid[0][0] ^ grid[0][1] ^ grid[0][2]) == a[0]) satisfied++;
            if ((grid[1][0] ^ grid[1][1] ^ grid[1][2]) == a[1]) satisfied++;
            if ((grid[2][0] ^ grid[2][1] ^ grid[2][2]) == a[0]) satisfied++;

            if ((grid[0][0] ^ grid[1][0] ^ grid[2][0]) == a[3]) satisfied++;
            if ((grid[0][1] ^ grid[1][1] ^ grid[2][1]) == a[4]) satisfied++;
            if ((grid[0][2] ^ grid[1][2] ^ grid[2][2]) == a[5]) satisfied++;

            if (satisfied >= k) {
                count ++;
            }

        }
        System.out.println(count);
    }
}