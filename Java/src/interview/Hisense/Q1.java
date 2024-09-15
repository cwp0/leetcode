package interview.Hisense;

import java.util.HashMap;

/**
 * @Program: Java
 * @Package: interview.Hisense
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/15 19:22
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

    }

    public int[] hitori (int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[n];

        for (int j = 0; j < n; j++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int val = mat[i][j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            for (int freq : map.values()) {
                if (freq == 1) {
                    res[j]++;
                }
            }

        }

        return res;
    }
}