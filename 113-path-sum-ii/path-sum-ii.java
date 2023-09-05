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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ansList = new ArrayList<>();
        traverse(root, targetSum, new ArrayList<>(), ansList);
        return ansList;
    }
    
    private void traverse(TreeNode root, int sum, List<Integer> ds, List<List<Integer>> ansList) {
        
        if(root == null) return;
        if(root.left == null && root.right == null && sum == root.val){
            ds.add(root.val);
            ansList.add(new ArrayList<>(ds));
            ds.remove(ds.size() - 1);
            return;
        }
        ds.add(root.val);
        traverse(root.left, sum-root.val, ds, ansList);
        traverse(root.right, sum-root.val, ds, ansList);
        ds.remove(ds.size()-1);
    }
}