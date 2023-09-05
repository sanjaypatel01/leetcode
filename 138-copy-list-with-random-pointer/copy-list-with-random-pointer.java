/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node start = head;
        while(start != null) {
            Node node = new Node(start.val);
            Node next = start.next;
            start.next = node;
            node.next = next;
            start = start.next.next;
        }
        start = head;
        while(start != null) {
            Node random = start.random != null ? start.random.next : null;
            start.next.random = random;
            start = start.next.next;
        }
        Node newList = new Node(0);
        Node dummy = newList;
        start = head;
        while(start != null) {
            newList.next = start.next;
            start.next = start.next.next;
            start = start.next;
            newList = newList.next;
        }
        
        return dummy.next;
    }
}