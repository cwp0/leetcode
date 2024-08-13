// 
// @Question: [124]二叉树中的最大路径和 
// @Author: cwp0
// @CreatedTime: 2024-08-13 14:34:12
// @Description: 
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2258 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
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
    private int ans = Integer.MIN_VALUE; // 不能定义为static
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        // 没有节点，和为0
        if (node == null) return 0;
        int leftVal = dfs(node.left); // 左子树最大链和
        int rightVal = dfs(node.right); // 右子树最大链和
        ans = Math.max(ans, leftVal + rightVal + node.val); // 两条链拼接
        return Math.max(Math.max(leftVal, rightVal) + node.val, 0); // 当前子树的最大链和
    }
}
//leetcode submit region end(Prohibit modification and deletion)
