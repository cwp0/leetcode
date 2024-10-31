package interview.PingAn;

/**
 * @Program: Java
 * @Package: interview.PingAn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/30 19:59
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int count = 0;

        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((i == 0 || isPalindrome[0][i-1]) && (j == n-1 || isPalindrome[j+1][n-1])) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}

