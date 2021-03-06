package problems.linkedlist;

import problems.common.util.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 难度：中等
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author kyan
 * @date 2020/1/18
 */
public class LeetCode_24_SwapPairs {

    /**
     * time 0ms, beat 100%
     * space 34.6MB, beat 5.26%
     */
    public static class Solution1 {

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode preHead = new ListNode(-1);
            ListNode pre = preHead;
            preHead.next = head;
            while (pre.next != null && pre.next.next != null) {
                ListNode pos1 = pre.next;
                ListNode pos2 = pre.next.next;
                pre.next = pos2;
                pos1.next = pos2.next;
                pos2.next = pos1;
                pre = pos1;
            }
            return preHead.next;
        }
    }


    public static void main(String[] args) {
        //1->2->3->4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.swapPairs(head));
        //should print 2->1->4->3
    }
}
