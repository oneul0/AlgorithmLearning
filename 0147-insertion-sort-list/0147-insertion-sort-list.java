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
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(-5001);

        while (head != null) {
            ListNode next = head.next;
            ListNode prev = sorted;

            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            head.next = prev.next;
            prev.next = head;

            head = next;
        }

        return sorted.next;
    }
}
//하나를 잡고
//그것보다 작은 수를 앞으로 보내는건가