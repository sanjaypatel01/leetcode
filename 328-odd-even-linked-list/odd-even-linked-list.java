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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = new ListNode(0, head);
        ListNode second = new ListNode(0, head.next);
        ListNode head1 = first;
        ListNode head2 = second;

        while(head != null && head.next != null) {
            first.next = head;
            second.next = head.next;
            first = first.next;
            second = second.next;
            head = head.next.next;
        }
        second.next = null;
        if(head != null) {
            first.next = head;
            first = first.next;
        }
        first.next = head2.next;
        return head1.next;
    }
}