// 
// @Question: [894]所有可能的真二叉树 
// @Author: cwp0
// @CreatedTime: 2024-04-02 13:41:23
// @Description: 
//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。 
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。 
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：[[0,0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 368 👎 0

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
    public List<TreeNode> allPossibleFBT(int n) {
        // 如果节点数为偶数，则构造不出真二叉树，返回空的ArrayList
        if (n % 2 == 0) {
            return new ArrayList<TreeNode>();
        }

        // 定义dp[n]为节点数量为n的真二叉树的列表集合
        List<TreeNode>[] dp = new List[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
        }

        // base case
        dp[1].add(new TreeNode(0));

        // 状态转移函数
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 左子树
                for (TreeNode leftSubTree : dp[j]) {
                    // 右子树
                    for (TreeNode rightSubTree : dp[i - 1 - j]) {
                        TreeNode root = new TreeNode(0, leftSubTree, rightSubTree);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];

    }



}
//leetcode submit region end(Prohibit modification and deletion)
