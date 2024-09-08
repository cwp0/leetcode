package interview.MiHoYo.Autumn;

/**
 * @Program: Java
 * @Package: interview.MiHoYo.Autumn
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 16:01
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        int maxCount = -1;
        int res = n;

        for (int i = n; i <= m; i++) {
            int count = countDigits(i);
            if (count > maxCount || (count == maxCount && i > res)) {
                maxCount = count;
                res = i;
            }
        }
        System.out.println(res);
    }

    private static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            int dight = num % 10;
            if (dight == 4 || dight == 6) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}