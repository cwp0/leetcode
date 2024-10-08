package interview.Shopee;

/**
 * @Program: Java
 * @Package: interview.Shopee
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/08 16:04
 * @Version: 1.0
 */

import java.util.*;

public class Q1 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param arr int整型 一维数组
     * @return int整型
     */
    public int find(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();

        backtrack(arr, 0, new ArrayList<>(), res);

        return res.size();
    }

    private void backtrack(int[] arr, int start, List<Integer> current, Set<List<Integer>> res) {
        if (current.size() >= 2) {
            res.add(new ArrayList<>(current));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (!current.isEmpty() && arr[i] < current.get(current.size() - 1) ||used.contains(arr[i])) {
                continue;
            }

            used.add(arr[i]);
            current.add(arr[i]);
            backtrack(arr, i+1, current, res);
            current.remove(current.size()-1);

        }
    }



    public static void main(String[] args) {

    }
}