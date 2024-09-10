package interview.GaoDe;

/**
 * @Program: Java
 * @Package: interview.GaoDe
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/10 19:01
 * @Version: 1.0
 */
public class Q3 {
    public int[] twoSum (int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}