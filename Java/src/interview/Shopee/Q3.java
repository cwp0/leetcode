package interview.Shopee;

import ds.ListNode;

/**
 * @Program: Java
 * @Package: interview.Shopee
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/08 16:04
 * @Version: 1.0
 */
public class Q3 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param node ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNode(ListNode node, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = node;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return node;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}