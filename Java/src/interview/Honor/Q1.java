package interview.Honor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.Honor
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/05/16 18:58
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] nums_str = str.substring(1, str.length()-1).split(" ");
        int[] nums = new int[nums_str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                sum += entry.getKey();
            }
        }
        System.out.println(sum);
    }
}