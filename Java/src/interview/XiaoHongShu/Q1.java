package interview.XiaoHongShu;

/**
 * @Program: Java
 * @Package: interview.XiaoHongShu
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/14 16:00
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            // 异或运算性质 ai xor aj = k，那么aj = k xor ai
            int target = a[i] ^ k;
            // 如果target已经存在，则增加结果
            res += map.getOrDefault(target, 0);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);

        }

        System.out.println(res);

    }
}