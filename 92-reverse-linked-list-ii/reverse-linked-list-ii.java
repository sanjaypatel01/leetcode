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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null) return head;

        ListNode start = new ListNode();
        ListNode dummy = start;
        ListNode first = null;
        ListNode last = null;
        start.next = head;
        int n=0;
        while(start != null) {
            if((n+1) == left) first = start;
            if(n == right) {
                last = start.next;
                start.next = null;
                System.out.println("LAST : "+ start.val);
                break;
            } 
            start = start.next;
            n++;
        }
        if(first != null) {
            ListNode tail = first.next;
            first.next = reverse(first.next);
            tail.next = last;
        }

       return dummy.next; 
    }

    private ListNode reverse(ListNode head) {
        ListNode prev=null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}