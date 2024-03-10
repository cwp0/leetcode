/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: ListNode
 * @Description: Definition for singly-linked list.
 * @Author: cwp0
 * @CreatedTime: 2024/03/10 15:30
 * @Version: 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode () {};
    ListNode (int val) { this.val = val; }
    ListNode (int val, ListNode next) { this.val = val; this.next = next; }
}