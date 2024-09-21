package interview.TongCheng58;

import java.util.ArrayList;

/**
 * @Program: Java
 * @Package: interview.TongCheng58
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/20 19:12
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param firstList int整型二维数组
     * @param secondList int整型二维数组
     * @return int整型二维数组
     */
    public int[][] findIntersection (int[][] firstList, int[][] secondList) {
        // write code here
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);

            if (start <= end) {
                res.add(new int[]{start, end});
            }

            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}