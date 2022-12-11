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
    int ans;
    public int maxPathSumUtil(TreeNode root, int min) {
        if(root == null) return -1000;
        int temp = root.val;
        
        int left = Math.max(0, maxPathSumUtil(root.left , min));
        int right = Math.max(0,maxPathSumUtil(root.right, min));
        
        temp += left;
        temp += right;
        
        if(ans < temp) {
            ans = temp;
        }
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxPathSumUtil(root, Integer.MIN_VALUE);
        return ans;
    }
}