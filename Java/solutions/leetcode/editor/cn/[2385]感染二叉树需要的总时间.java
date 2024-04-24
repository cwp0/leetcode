// 
// @Question: [2385]感染二叉树需要的总时间 
// @Author: cwp0
// @CreatedTime: 2024-04-24 22:24:25
// @Description: 
//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。 
//
// 每分钟，如果节点满足以下全部条件，就会被感染： 
//
// 
// 节点此前还没有感染。 
// 节点与一个已感染节点相邻。 
// 
//
// 返回感染整棵树需要的分钟数。 
//
// 
//
// 示例 1： 
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
// 
//
// 示例 2： 
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 每个节点的值 互不相同 
// 树中必定存在值为 start 的节点 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 96 👎 0

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
    private TreeNode startNode;
    private final Map<TreeNode, TreeNode> fa = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        return maxDepth(startNode, startNode);
    }

    private void dfs(TreeNode node, TreeNode from, int start) {
        if (node == null) {
            return;
        }
        fa.put(node, from); // 记录每个节点的父节点
        if (node.val == start) {
            startNode = node; // 找到 start
        }
        dfs(node.left, node, start);
        dfs(node.right, node, start);
    }

    private int maxDepth(TreeNode node, TreeNode from) {
        if (node == null) {
            return -1; // 注意这里是 -1，因为 start 的深度为 0
        }
        int res = -1;
        if (node.left != from) {
            res = Math.max(res, maxDepth(node.left, node));
        }
        if (node.right != from) {
            res = Math.max(res, maxDepth(node.right, node));
        }
        if (fa.get(node) != from) {
            res = Math.max(res, maxDepth(fa.get(node), node));
        }
        return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
