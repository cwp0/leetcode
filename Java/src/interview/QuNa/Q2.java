package interview.QuNa;

/**
 * @Program: Java
 * @Package: interview.QuNa
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 14:38
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        String str = scanner.nextLine();
        char[] chars = str.toCharArray();

        boolean[] fixed = new boolean[n];


        for (int i = 0; i < q; i++) {
            int opt = scanner.nextInt();

            if (opt == 1) {
                int u = scanner.nextInt() - 1;
                fixed[u] = true;
            } else if (opt == 2) {
                List<Character> flowChars = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (!fixed[j]) {
                        flowChars.add(chars[j]);
                    }
                }

                if (!flowChars.isEmpty()) {
                    char lastChar = flowChars.get(flowChars.size() - 1);
                    for (int j = flowChars.size()-1; j > 0; j--) {
                        flowChars.set(j, flowChars.get(j-1));
                    }
                    flowChars.set(0, lastChar);
                }

                int flowIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (!fixed[j]) {
                        chars[j] = flowChars.get(flowIndex++);
                    }
                }

            }
        }
        System.out.println(new String(chars));
    }
}