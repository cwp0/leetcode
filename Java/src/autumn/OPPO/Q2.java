package autumn.OPPO;

/**
 * @Program: Java
 * @Package: autumn.OPPO
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 19:33
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int MEX = 0;
        while (freq.containsKey(MEX)) {
            MEX++;
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (freq.get(a[i]) > 1) {
                res[i] = MEX;
            } else {
                if (a[i] < MEX) {
                    res[i] = a[i];
                } else {
                    res[i] = MEX;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }

    }
}