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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = convertToList(head);
        return convertToBST(0, list.size() - 1, list);
    }

    private TreeNode convertToBST(int start, int end, List<Integer> list) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = convertToBST(start, mid - 1, list);
        root.right = convertToBST(mid + 1, end, list);
        return root;
    }


    private List<Integer> convertToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}