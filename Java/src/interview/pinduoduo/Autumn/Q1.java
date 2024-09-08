package interview.pinduoduo.Autumn;



/**
 * @Program: Java
 * @Package: interview.pinduoduo.Autumn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/08 15:06
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String s = scanner.next();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        int prefixSum = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'A') {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            if (map.containsKey(prefixSum)) {
                int preIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - preIndex);
            } else {
                map.put(prefixSum, i);
            }
        }
        System.out.println(maxLen);
    }
}