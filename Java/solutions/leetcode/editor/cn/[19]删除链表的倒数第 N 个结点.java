// 
// @Question: [19]删除链表的倒数第 N 个结点 
// @Auther: cwp0
// @CreatedTime: 2024-03-07 21:41:08
// @Description: 
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2822 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 返回链表的倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先向前走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        // p1 和 p2 一起向前走， p1 走到结尾
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // 此时 p2 所在就是倒数第 k 个结点
        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 这里有点疑问？
        ListNode tar = findFromEnd(dummy, n); // 注意这里使用dummy的技巧，巧妙利用dummy，不用分开讨论删除头结点的情况。
        // 找到要删除的结点的前面的结点，然后让其指向该结点所指向的结点，跳过该结点，就等于删除。
        tar.next = tar.next.next;

        // 注意返回 dummy.next
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
