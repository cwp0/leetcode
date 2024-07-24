// 
// @Question: [2766]重新放置石块 
// @Author: cwp0
// @CreatedTime: 2024-07-24 21:15:08
// @Description: 
//给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 
//moveTo 。 
//
// 在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 
//moveTo[i] 。 
//
// 完成这些操作后，请你按升序返回所有 有 石块的位置。 
//
// 注意： 
//
// 
// 如果一个位置至少有一个石块，我们称这个位置 有 石块。 
// 一个位置可能会有多个石块。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,6,7,8], moveFrom = [1,7,2], moveTo = [2,9,5]
//输出：[5,6,8,9]
//解释：一开始，石块在位置 1,6,7,8 。
//第 i = 0 步操作中，我们将位置 1 处的石块移到位置 2 处，位置 2,6,7,8 有石块。
//第 i = 1 步操作中，我们将位置 7 处的石块移到位置 9 处，位置 2,6,8,9 有石块。
//第 i = 2 步操作中，我们将位置 2 处的石块移到位置 5 处，位置 5,6,8,9 有石块。
//最后，至少有一个石块的位置为 [5,6,8,9] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,3,3], moveFrom = [1,3], moveTo = [2,2]
//输出：[2]
//解释：一开始，石块在位置 [1,1,3,3] 。
//第 i = 0 步操作中，我们将位置 1 处的石块移到位置 2 处，有石块的位置为 [2,2,3,3] 。
//第 i = 1 步操作中，我们将位置 3 处的石块移到位置 2 处，有石块的位置为 [2,2,2,2] 。
//由于 2 是唯一有石块的位置，我们返回 [2] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= moveFrom.length <= 10⁵ 
// moveFrom.length == moveTo.length 
// 1 <= nums[i], moveFrom[i], moveTo[i] <= 10⁹ 
// 测试数据保证在进行第 i 步操作时，moveFrom[i] 处至少有一个石块。 
// 
//
// Related Topics 数组 哈希表 排序 模拟 👍 33 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        for (int i = 0; i < moveFrom.length; i++) {

            map.remove(moveFrom[i]);
            map.put(moveTo[i], true);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            res.add(entry.getKey());
        }

        Collections.sort(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
