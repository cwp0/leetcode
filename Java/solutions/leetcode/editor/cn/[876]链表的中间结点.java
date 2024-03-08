// 
// @Question: [876]链表的中间结点 
// @Auther: cwp0
// @CreatedTime: 2024-03-08 10:28:53
// @Description: 
//给你单链表的头结点 head ，请你找出并返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 链表 双指针 👍 977 👎 0

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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) { // fast != null 对应fast指向最后结点之后的地方，fast.next != null对应fast指向最后一个结点。
            // slow 指针走一步，fast 指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }

        // 最后 slow 指针指向中点，链表结点为偶数时指向两个中点考后的那个。
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
