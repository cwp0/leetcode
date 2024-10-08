// 
// @Question: [997]找到小镇的法官 
// @Author: cwp0
// @CreatedTime: 2024-09-22 16:15:38
// @Description: 
//小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。 
//
// 如果小镇法官真的存在，那么： 
//
// 
// 小镇法官不会信任任何人。 
// 每个人（除了小镇法官）都信任这位小镇法官。 
// 只有一个人同时满足属性 1 和属性 2 。 
// 
//
// 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。 
//
// 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 10⁴ 
// trust[i].length == 2 
// trust 中的所有trust[i] = [ai, bi] 互不相同 
// ai != bi 
// 1 <= ai, bi <= n 
// 
//
// Related Topics 图 数组 哈希表 👍 352 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            return n > 1 ? -1 : 1;
        }
        // 某个人被多少人相信
        HashMap<Integer, Integer> map = new HashMap<>();
        // 某人相信多少个人
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int[] t : trust) {
            map.put(t[1], map.getOrDefault(t[1], 0) + 1);
            map1.put(t[0], map.getOrDefault(t[0], 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i) && map.get(i) == n-1 && !map1.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
