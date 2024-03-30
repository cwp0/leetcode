// 
// @Question: [543]二叉树的直径 
// @Author: cwp0
// @CreatedTime: 2024-03-12 21:47:42
// @Description: 
//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1497 👎 0

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

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    // 计算二叉树的最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 前序遍历
        int leftMax = maxDepth(root.left);

        // 中序遍历

        int rightMax = maxDepth(root.right);

        // 后序遍历
        // 后序遍历能获取左右子树的最大深度，所以在这里计算。
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        // 注意返回的是树的最大深度，不是最大直径。
        return 1 + Math.max(leftMax, rightMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
