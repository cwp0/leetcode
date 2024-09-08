package interview.pinduoduo.Autumn;

/**
 * @Program: Java
 * @Package: interview.pinduoduo.Autumn
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/08 15:06
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    static int n, q;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();

            if (op == 1) {
                int x = scanner.nextInt() - 1; // 直接转换下标
                int y = scanner.nextInt();
                arr[x] = y;
            } else if (op == 2) {
                System.out.println(findMaxSimilarSubArr());
            }
        }
        scanner.close();
    }

    private static int findMaxSimilarSubArr() {
        Map<String, Integer> subArrayMap = new HashMap<>();
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            List<Integer> subArray = new ArrayList<>();
            for (int end = start; end < n; end ++) {
                subArray.add(arr[end]);
                List<Integer> sortedSubArray = new ArrayList<>(subArray);
                Collections.sort(sortedSubArray);
                String key = sortedSubArray.toString();
                subArrayMap.put(key, subArrayMap.getOrDefault(key, 0) + 1);

                if (subArrayMap.get(key) > 1) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

}