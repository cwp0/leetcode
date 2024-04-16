// 
// @Question: [337]打家劫舍 III 
// @Author: cwp0
// @CreatedTime: 2024-04-15 22:31:10
// @Description: 
//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1967 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private HashMap<TreeNode, Integer> memo;
    public int rob(TreeNode root) {
        memo = new HashMap<TreeNode, Integer>();
        return dp(root);
    }

    private int dp(TreeNode root) {
        // base case
        if (root == null) return 0;

        if (memo.containsKey(root)) return memo.get(root);

        // 第一种情况，盗窃root节点，然后不能盗窃root.left节点和root.right节点
        int first = root.val
                + (root.left == null ?
                0 : dp(root.left.left) + dp(root.left.right))
                + (root.right == null ?
                0 : dp(root.right.left) + dp(root.right.right));

        // 第二种情况，不盗窃root节点，盗窃root.left和root.right节点
        int second = dp(root.left) + dp(root.right);
        int res = Math.max(first, second);
        memo.put(root, res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
