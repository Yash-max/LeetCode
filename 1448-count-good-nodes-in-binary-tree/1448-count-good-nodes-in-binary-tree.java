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
    void util(TreeNode root, int x) {
        if(root == null) return;
        if(root.val >= x) {
            ans++;
        }
        x = Math.max(x, root.val);
        util(root.left, x);
        util(root.right, x);
    }
    public int goodNodes(TreeNode root) {
        ans = 1;
        util(root.left, root.val);
        util(root.right, root.val);
        return ans;
    }
}