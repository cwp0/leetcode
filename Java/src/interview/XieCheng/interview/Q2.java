package interview.XieCheng.interview;

/**
 * @Program: Java
 * @Package: interview.XieCheng.interview
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/11 19:03
 * @Version: 1.0
 */

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


}

public class Q2 {
    // 二叉树的先序遍历，然后按照前序顺序将其转化为一个链表
    public static void main(String[] args) {

    }

    private static Node trans(TreeNode root) {
        Node dummy = new Node(-1);
        Node p = null;
        dummy.next = p;

        traverse(root, p);

        return dummy.next.next;
    }

    private static void traverse(TreeNode root, Node p) {
        if (root == null)
            return ;

        Node node = new Node(root.val, null);
        p.next = node;
        p = p.next;

        traverse(root.left, p);

        traverse(root.right, p);

    }

}