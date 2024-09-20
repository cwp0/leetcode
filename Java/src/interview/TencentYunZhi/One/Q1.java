package interview.TencentYunZhi.One;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/18 16:34
 * @Version: 1.0
 */
class ListNode {
    ListNode next;
    int val;
    ListNode(int val) {
        this.val = val;
    }
}
public class Q1 {
    // 输入是一个链表，找到倒数第n个节点

    public static void main(String[] args) {

    }

    static ListNode nNode(ListNode head, int n) {
        // 边界情况

        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }


}