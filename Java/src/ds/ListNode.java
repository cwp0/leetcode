package ds;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: ds.ListNode
 * @Description: Definition for singly-linked list.
 * @Author: cwp0
 * @CreatedTime: 2024/03/10 15:30
 * @Version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode () {};
    public ListNode (int val) { this.val = val; }
    public ListNode (int val, ListNode next) { this.val = val; this.next = next; }
}