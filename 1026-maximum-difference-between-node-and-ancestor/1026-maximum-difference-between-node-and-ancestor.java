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
    public int maxAncestorDiffUtil(TreeNode root, int min, int max) {
        if(root == null) return 0;
        
        int ans = Math.max(
            Math.abs(root.val-min),
            Math.abs(root.val-max)
        );
        
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        
        int itr = Math.max(
            maxAncestorDiffUtil(root.left, min, max), 
            maxAncestorDiffUtil(root.right, min, max)
        );
        
        ans = Math.max(ans, itr);
        
        return ans;
    }
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(
            maxAncestorDiffUtil(root.left, root.val, root.val), 
            maxAncestorDiffUtil(root.right, root.val, root.val)
        );
    }
}