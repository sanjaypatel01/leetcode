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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        while(!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            for(int i=0; i < n; i++) {
                TreeNode node  = queue.poll();
                sum +=node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(max < sum){
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}