package interview.WangYi.YouDao;

/**
 * @Program: Java
 * @Package: interview.WangYi.YouDao
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/28 10:03
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine().trim();
        int y = 0;

        while (true) {
            String sum = addStrings(x, String.valueOf(y));
            if (isPalid(sum)) {
                System.out.println(y);
                break;
            }
            y++;
        }

    }

    private static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;

        }

        return res.reverse().toString();
    }

    private static boolean isPalid(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}