package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 19:01
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            System.out.println(getScore(num));
        }
    }

    private static int getScore(int num) {
        String s = Integer.toString(num);
        if(num < 10) {
            s = "000" + s;
        } else if (num >= 10 && num < 100) {
            s = "00" + s;
        } else if (num >= 100 && num < 1000) {
            s = "0" + s;
        }

        int[] arr = new int[4];
        int score = 0;
        for (int i = 0; i < 4; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        if (arr[0] == arr[1] && arr[2] == arr[3] && arr[1] != arr[2]) {
            score += 3;
        }
        if (arr[0] == arr[2] && arr[1] == arr[3] && arr[0] != arr[1]) {
            score += 2;
        }
        if (arr[0] % 2 == 0 && arr[1] % 2 == 0 && arr[2] % 2 == 0 && arr[3] % 2 == 0) {
            score += 2;
        }
        if (arr[0] % 2 == 1 && arr[1] % 2 == 1 && arr[2] % 2 == 1 && arr[3] % 2 == 1) {
            score += 2;
        }
        if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2] && arr[2] + 1 == arr[3]) {
            score += 10;
        }
        if (arr[0] - 1 == arr[1] && arr[1] - 1 == arr[2] && arr[2] - 1 == arr[3]) {
            score += 10;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] == 3 || arr[i] == 6) {
                score += 1;
            }
        }
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
            score += 8;
        }
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] != arr[3]) {
            score += 4;
        }
        if (arr[0] != arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
            score += 4;
        }


        return score;
    }

}