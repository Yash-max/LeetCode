class Solution {
    public TreeNode util(TreeNode root, int val, int depth, boolean flag) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            if(flag) {
                newRoot.left = root;   
            } else {
                newRoot.right = root;
            }
            return newRoot;
        }
        if(root == null) return root;
        root.left  = util(root.left,  val, depth-1, true);
        root.right = util(root.right, val, depth-1, false);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        root.left  = util(root.left,  val, depth-1, true);
        root.right = util(root.right, val, depth-1, false);
        return root;
    }
}