class Solution {
    int prev;
    int ans;
    public void minDiffInBSTUtil(TreeNode root) {
        if(root == null) return;
        minDiffInBSTUtil(root.left);
        if(ans > (root.val-prev)) {
            ans = (root.val-prev);
        }
        prev = root.val;
        minDiffInBSTUtil(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        prev = -1000000;
        ans = 1000000;
        minDiffInBSTUtil(root);
        return ans;
    }
}