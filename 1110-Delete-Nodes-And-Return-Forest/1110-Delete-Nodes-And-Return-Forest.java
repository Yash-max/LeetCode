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
    public void delNodesUtil(TreeNode root, Set<Integer> to_delete_map, List<TreeNode> roots) {
        if(root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(to_delete_map.contains(root.val)) {
                to_delete_map.remove(root.val);
                root.left = null;
                root.right = null;
                root = null;
                if(left != null && !to_delete_map.contains(left.val)) {
                    roots.add(left);
                }
                if(right != null && !to_delete_map.contains(right.val)) {
                    roots.add(right);
                }
            } else {
                if(left != null && to_delete_map.contains(left.val)) {
                    root.left = null;
                }
                if(right != null && to_delete_map.contains(right.val)) {
                    root.right = null;
                }
            }
            delNodesUtil(left, to_delete_map, roots);
            delNodesUtil(right, to_delete_map, roots);
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();
        Set<Integer> to_delete_map = new HashSet<>();
        for(int x: to_delete) {
            to_delete_map.add(x);
        }
        if(!to_delete_map.contains(root.val)) {
            roots.add(root);
        }
        delNodesUtil(root, to_delete_map, roots);
        // System.out.println(roots);
        return roots;
    }
}