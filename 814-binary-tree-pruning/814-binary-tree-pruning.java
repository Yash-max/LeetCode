class Solution {
    public boolean util(TreeNode root) {
        
        if(root == null) return false;
        
        boolean flag = false;
        
        if(!util(root.left)) {
            root.left = null;
        } else flag = true;
        
        if(!util(root.right)) {
            root.right = null;
        } else flag = true;
        
        if(root.val == 1) {
            flag = true;
        }
        
        return flag;
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if(!util(root)) return null;
        return root;
    }
}