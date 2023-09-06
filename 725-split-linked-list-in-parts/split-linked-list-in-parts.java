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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode []ansList = new ListNode[k];
        ListNode start = head;
        int n = length(start);
        int eachPart = n/k;
        int extraPart = n % k;
        start = head;
        int i=0;
        while(start != null) {
            int count = 0;
            int nodeCount = eachPart + ((extraPart > 0) ? 1 : 0);
            extraPart--;
            ListNode dummy = new ListNode(0);
            ListNode dStart = dummy;
            ListNode prev=null;
            while(count < nodeCount && start != null) {
                dummy.next = start;
                prev = start;
                dummy = dummy.next;
                start = start.next;
                count++;
            }
            
            if(prev != null) prev.next = null;
            ansList[i++] = dStart.next;
        }
        return ansList;
    }
    
    private int length(ListNode start){
        int count = 0;
        while(start != null) {
            start = start.next;
            count++;
        }
        return count;
    }
}