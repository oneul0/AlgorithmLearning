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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(0);
        ListNode merged = tmp;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                merged.next = list1;
                list1 = list1.next;
            }
            else {
                merged.next = list2;
                list2 = list2.next;
            }

            merged = merged.next;
        }
        if(list1 !=null){
            merged.next = list1;
        }
        else{
            merged.next = list2;
        }

        return tmp.next;
    }
}