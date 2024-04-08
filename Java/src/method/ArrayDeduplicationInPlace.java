package method;

import java.util.Arrays;

/**
 * @Program: Java
 * @Package: method
 * @Class: ArrayDeduplicationInPlace
 * @Description: 数组的原地去重技巧
 * @Author: cwp0
 * @CreatedTime: 2024/04/08 22:29
 * @Version: 1.0
 */
public class ArrayDeduplicationInPlace {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 5};

        Arrays.sort(nums);
        int n = nums.length;
        int m = 1; // m最后的值是去重后数组长度
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) {
                nums[m++] = nums[i]; // 原地去重
            }
        }

        for (int i = 0; i < m; i ++) { // 注意这里的m
            System.out.println(nums[i]);
        }
    }


}