package interview.TencentYunZhi.Autumn;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi.Autumn
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/12 11:04
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(countSubstrings(s));
    }
    private static int countSubstrings(String s ) {
        int total = 0;
        String[] parts = s.split("d");

        for (String part : parts) {
            if (part.contains("r") && part.contains("e")) {
                total += countValidSubStr(part);
            }
        }
        return total;
    }
    private static int countValidSubStr(String s) {
        int n = s.length();
        int count = 0;

        int rPos = -1, ePos = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'r') {
                rPos = i;
            }
            if (s.charAt(i) == 'e') {
                ePos = i;
            }
            if (rPos != -1 && ePos != -1) {
                count += Math.min(rPos, ePos) + 1;
            }
        }
        return count;
    }
}