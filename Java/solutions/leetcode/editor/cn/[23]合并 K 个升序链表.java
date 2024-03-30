// 
// @Question: [23]合并 K 个升序链表 
// @Author: cwp0
// @CreatedTime: 2024-03-07 21:06:32
// @Description: 
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2772 👎 0

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点创建新的链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 优先级队列，默认从小到大排列，最前面就是最小的值。
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) { // 以结点的值来比较大小
                return o1.val - o2.val;
            }
        });

        // 将所有连标的头结点加入优先级队列
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 取出优先级队列的头元素，该元素就是所有链表头节点中最小的。
            ListNode temp = pq.poll();
            // 取出的头节点加入到新的链表中
            p.next = temp;

            // 如果包含temp结点的链表的元素不为空，则该链表前进向下一个元素
            if (temp.next != null) {
                pq.add(temp.next);
            }
            // 新链表p前进
            p = p.next;
        }
        // 注意返回的是虚拟头结点的下一个元素
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
