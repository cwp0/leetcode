package interview.XieCheng.interview;

/**
 * @Program: Java
 * @Package: interview.XieCheng.interview
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/11 18:16
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

public class Q1 {

    // 有序链表的合并, 升序
    public static void main(String[] args) {

    }

    private static Node merge(Node p1, Node p2) {

        Node dummy = new Node(-1);
        Node p = null;
        dummy.next = p;

        if (p1.val < p2.val) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
        }else {
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}