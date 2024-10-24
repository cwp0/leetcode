// 
// @Question: [739]每日温度 
// @Author: cwp0
// @CreatedTime: 2024-10-24 13:51:38
// @Description: 
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1846 👎 0

import java.util.Stack;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        // 倒着往栈里放数组
        for (int i = n-1; i >= 0; i--) {
            // 判断每个索引所在的温度大小
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                // 温度较低的直接出栈
                stack.pop();
            }
            // i后的较高温度与i的距离
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
