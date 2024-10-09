package interview.HeMa;

/**
 * @Program: Java
 * @Package: interview.HeMa
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/09 19:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = scanner.nextInt();
        }
        Arrays.sort(h);
        for (int i = 0; i < N; i++) {
            if (h[i] <= L) {
                L++;
            } else {
                break;
            }
        }
        System.out.println(L);
    }
}