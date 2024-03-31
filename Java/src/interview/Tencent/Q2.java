package interview.Tencent;

import ds.TreeNode;

/**
 * @Program: Java
 * @Package: interview.Tencent
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 20:15
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {

    }
    public int number_of_different_plans (TreeNode root, int l, int r) {
        // write code here
        return dfs(root, 0, l, r);
    }
    public int dfs(TreeNode node, int cur,  int l, int r) {
        if (node == null) return 0;

        cur = (cur << 1) | node.val;

        if (node.left == null && node.right == null) {
            return (cur >=1 && cur <= r) ? 1 : 0;
        }

        int leftPlans = dfs(node.left, cur, l, r);
        int rightPlans = dfs(node.right, cur, l, r);

        return leftPlans + rightPlans;
    }
}