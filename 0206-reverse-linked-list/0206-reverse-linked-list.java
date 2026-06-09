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
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode newHead = reverseList(head.next);

    //     head.next.next = head;
    //     head.next = null;

    //     return newHead;
    // }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            //뒤집기
            ListNode next = cur.next;
            cur.next = prev;
            //한칸이동
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}