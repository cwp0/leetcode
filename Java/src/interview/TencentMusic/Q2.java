package interview.TencentMusic;

/**
 * @Program: Java
 * @Package: interview.TencentMusic
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/05 19:01
 * @Version: 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Q2 {
    public ListNode mergeList (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 前缀
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode a = headA, b = headB;
        while (a != null && b != null && a.val == b.val) {
            ListNode tmp = new ListNode(a.val);
            p.next = tmp;
            p = p.next;

            a = a.next;
            b = b.next;
        }

        ListNode revA = reverse(headA);
        ListNode revB = reverse(headB);

        ListNode c = revA, d = revB;
        // 后缀
        ListNode dummy1 = new ListNode(-1), p1 = dummy1;
        while (c != null && d != null && c.val == d.val) {
            ListNode tmp = new ListNode(c.val);
            p1.next = tmp;
            p1 = p1.next;

            c = c.next;
            d = d.next;
        }

        // 拼接
        p.next = reverse(dummy1.next);

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 打印链表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Q2 solution = new Q2();

        // 构造链表a: 1 -> 2 -> 2 -> 3 -> 4
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(4);

        // 构造链表b: 1 -> 2 -> 1 -> 2 -> 3 -> 3 -> 4
        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(2);
        b.next.next.next.next = new ListNode(3);
        b.next.next.next.next.next = new ListNode(3);
        b.next.next.next.next.next.next = new ListNode(4);

        // 合并两个链表
        ListNode result = solution.mergeList(a, b);

        printList(result);  // 期望输出：1 2 3 4
    }


}