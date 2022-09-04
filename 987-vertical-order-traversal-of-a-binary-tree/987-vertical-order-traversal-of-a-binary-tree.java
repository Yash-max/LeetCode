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
    Map<Integer, Map<Integer, List<Integer>>> map;
    private void util(TreeNode root, int x, int y) {
        if(root == null) return;
        
        if(map.containsKey(x)) {
            Map<Integer, List<Integer>> temp = map.get(x);
            List<Integer> list = null;
            if(temp.containsKey(y)) {
                list = temp.get(y);
            } else {
                list = new ArrayList<>();
            }
            list.add(root.val);
            temp.put(y, list);
            map.put(x, temp);
        } else {
            Map<Integer, List<Integer>> temp = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            temp.put(y, list);
            map.put(x, temp);
        }
        util(root.left,  x-1, y+1);
        util(root.right, x+1, y+1);
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>(); 
        util(root, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer x : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            
            Map<Integer, List<Integer>> innerMap = map.get(x);
            for(Integer y : innerMap.keySet()) {
                List<Integer> itr = innerMap.get(y);
                Collections.sort(itr);
                list.addAll(itr);
            }
            
            ans.add(list);
        }
        return ans;
    }
}