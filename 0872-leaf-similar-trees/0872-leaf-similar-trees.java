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
    public void queuePopulator(TreeNode root, Queue<Integer> q) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            q.add(root.val);
        }
        queuePopulator(root.left, q);
        queuePopulator(root.right, q);
    }
    public boolean queueChecker(TreeNode root, Queue<Integer> q) {
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            if(!q.isEmpty() && root.val == q.poll()) {
                return true;
            } else {
                return false;
            }
        }
        return queueChecker(root.left, q) && queueChecker(root.right, q);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q = new LinkedList<>();
        queuePopulator(root1, q);
        if(queueChecker(root2, q) && q.size() == 0) {
            return true;
        }
        return false;
    }
}