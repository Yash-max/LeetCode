class Solution {
    int ans;
    int prev;
    public void getMinimumDifferenceUtil(TreeNode root) {
        if(root == null) return;
        getMinimumDifferenceUtil(root.left);
        if(ans > (root.val-prev)) {
            ans = (root.val-prev);
        }
        prev = root.val;
        getMinimumDifferenceUtil(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        ans  = 1000000;
        prev = -1000000;
        getMinimumDifferenceUtil(root);
        return ans;
    }
}