package interview.QuNa;

/**
 * @Program: Java
 * @Package: interview.QuNa
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 14:38
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();

        String kStr = String.valueOf(k);

        List<Integer> res = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (i % k == 0 || String.valueOf(i).contains(kStr)) {
                res.add(i);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
        System.out.println();
    }
}