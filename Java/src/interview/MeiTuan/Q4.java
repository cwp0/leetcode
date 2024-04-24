package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/24 22:23
 * @Version: 1.0
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 *
 **/
public class Q4 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // write your code here.
        int index = 0;
        ListNode p = head;
        ListNode begin = head;
        while (p != null && index < left) {
            index++;
            p = p.next;
        }
        ListNode p1 = p;
        ListNode head1 = p;
        ListNode last = null;
        for (int i = 0; i < right-left; i++) {
            p1 = p1.next;
        }
        last = p1.next;
        ListNode rev = reverseList(p1);

        p.next = rev;
        ListNode p2 = rev;
        while (rev != null) {
            p2 = p2.next;
        }
        p2.next = last;
        return begin;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}