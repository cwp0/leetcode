package interview.TencentYunZhi.Autumn;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi.Autumn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/12 11:04
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while (T-- > 0) {
            String s = scanner.nextLine();
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int index = i + 1;
                char ch = s.charAt(i);

                if (countOne(index) % 2 == 1) {
                    res.append(Character.toUpperCase(ch));
                } else {
                    res.append(ch);
                }
            }
            System.out.println(res.toString());
        }
        scanner.close();
    }

    private static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}