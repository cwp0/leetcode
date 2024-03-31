package ds;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: ds.TreeNode
 * @Description: Definition for a binary tree node.
 * @Author: cwp0
 * @CreatedTime: 2024/03/12 16:16
 * @Version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode () {};
    public TreeNode (int val) { this.val = val; }
    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void traverse (TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历
        // System.out.println(root.val); // 1 2 3
        traverse(root.left);

        // 中序遍历
        // System.out.println(root.val); // 2 1 3

        traverse(root.right);

        // 后序遍历
        // System.out.println(root.val); // 2 3 1

    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode root = new TreeNode(1, l, r);
        traverse(root);
    }

}