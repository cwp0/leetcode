package interview.Tencent;

import ds.ListNode;

/**
 * @Program: Java
 * @Package: interview.Tencent
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 20:02
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

    }
    public static ListNode deleteNode (ListNode head, int k) {
        // write code here
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 遍历
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == k) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}