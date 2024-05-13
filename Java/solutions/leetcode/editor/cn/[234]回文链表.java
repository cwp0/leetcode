// 
// @Question: [234]回文链表 
// @Author: cwp0
// @CreatedTime: 2024-05-13 19:54:52
// @Description: 
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1899 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
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
    private static final int MAX_N = 100001;
    private int[] nums = new int[MAX_N];
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode p = head;
        int len = 0;
        for (int i = 1; i < MAX_N; i++) {
            nums[i] = p.val;
            if (p.next != null) {
                p = p.next;
            } else {
                len = i;
                break;
            }
        }
        return isPalindrome(1, len);
    }

    private boolean isPalindrome(int start_index, int end_index) {
        int left = start_index, right = end_index;
        while (left < right && nums[left] == nums[right]) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        } else {
            return false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
