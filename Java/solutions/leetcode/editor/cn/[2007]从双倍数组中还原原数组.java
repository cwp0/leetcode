// 
// @Question: [2007]从双倍数组中还原原数组 
// @Author: cwp0
// @CreatedTime: 2024-04-18 15:06:07
// @Description: 
//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 哈希表 排序 👍 52 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int ansIdx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : changed) {
            if (!cnt.containsKey(x)) { // x 不是双倍后的元素
                if (ansIdx == ans.length) {
                    return new int[0];
                }
                ans[ansIdx++] = x;
                cnt.merge(x * 2, 1, Integer::sum); // 标记一个双倍元素
            } else { // x 是双倍后的元素
                int c = cnt.merge(x, -1, Integer::sum); // 清除一个标记
                if (c == 0) {
                    cnt.remove(x);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
