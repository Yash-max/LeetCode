class Solution {
    List<Integer> ans;
    public void inorder(TreeNode root) {
        if(root == null) return;
        ans.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorder(root);
        return ans;
    }
}