// 
// @Question: [2225]找出输掉零场或一场比赛的玩家 
// @Author: cwp0
// @CreatedTime: 2024-05-22 14:11:40
// @Description: 
//给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 
//loseri 。 
//
// 返回一个长度为 2 的列表 answer ： 
//
// 
// answer[0] 是所有 没有 输掉任何比赛的玩家列表。 
// answer[1] 是所有恰好输掉 一场 比赛的玩家列表。 
// 
//
// 两个列表中的值都应该按 递增 顺序返回。 
//
// 注意： 
//
// 
// 只考虑那些参与 至少一场 比赛的玩家。 
// 生成的测试用例保证 不存在 两场比赛结果 相同 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//输出：[[1,2,10],[4,5,7,8]]
//解释：
//玩家 1、2 和 10 都没有输掉任何比赛。
//玩家 4、5、7 和 8 每个都输掉一场比赛。
//玩家 3、6 和 9 每个都输掉两场比赛。
//因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
// 
//
// 示例 2： 
//
// 
//输入：matches = [[2,3],[1,3],[5,4],[6,4]]
//输出：[[1,2,5,6],[]]
//解释：
//玩家 1、2、5 和 6 都没有输掉任何比赛。
//玩家 3 和 4 每个都输掉两场比赛。
//因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= matches.length <= 10⁵ 
// matches[i].length == 2 
// 1 <= winneri, loseri <= 10⁵ 
// winneri != loseri 
// 所有 matches[i] 互不相同 
// 
//
// Related Topics 数组 哈希表 计数 排序 👍 45 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        // 记录loser的输的次数
        HashMap<Integer, Integer> loser_map = new HashMap<>();

        // 记录winner
        HashSet<Integer> set = new HashSet<>();

        for (int[] match : matches) {
            set.add(match[0]);
            loser_map.put(match[1], loser_map.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> ans1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : loser_map.entrySet()) {
            // 找到只输一场的loser
            if (entry.getValue() == 1) {
                ans1.add(entry.getKey());
            }

            // 移除输过的winner，set中剩下的就是没有输过的winner
            set.remove(entry.getKey());
        }

        List<Integer> ans0 = new ArrayList<>(set);
        ans0.sort((a, b)-> a - b);
        ans1.sort((a, b) -> a - b);
        answer.add(ans0);
        answer.add(ans1);
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
