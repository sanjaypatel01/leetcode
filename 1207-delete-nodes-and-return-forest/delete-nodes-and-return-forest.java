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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ansList = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int del: to_delete) toDelete.add(del);
        removeNodes(root, ansList, toDelete);
       // If root is not in delete list, then add root also in remaining list.
       if(!toDelete.contains(root.val)){
            ansList.add(root);
        } 

        return ansList;
    }

    private TreeNode removeNodes(TreeNode root, List<TreeNode> ansList, Set<Integer> toDelete) {
        if(root == null) return null;

        root.left = removeNodes(root.left, ansList, toDelete);
        root.right = removeNodes(root.right, ansList, toDelete);
        if(toDelete.contains(root.val)) {
            //Adding left and right childs as remaining from target nodes.
            if(root.left != null) ansList.add(root.left);
            if(root.right != null) ansList.add(root.right);
            return null;
        }
        return root;
    }
}