package autumn.JingDong;

/**
 * @Program: Java
 * @Package: autumn.JingDong
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 16:38
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int start = 0;
        int end = 2;
        int maxLen = 2;

        for (int i = 0; i < n-2; i++) {
            for (int j = i + 2; j < n; j++) {
                int[] subArray = Arrays.copyOfRange(a, i, j+1);
                Arrays.sort(subArray);
                boolean vaild = true;
                for (int k = 2; k < subArray.length; k++) {
                    if (subArray[k-2] + subArray[k-1] <= subArray[k]) {
                        vaild = false;
                        break;
                    }
                }

                if (vaild && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }


            }
        }
        System.out.println((start + 1) + " " + (end + 1));
    }
}