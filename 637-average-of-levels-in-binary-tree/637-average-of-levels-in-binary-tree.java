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
    Map<Integer, Pair<Integer, Long>> mp;
    public void util(TreeNode root, int l) {
        if(root == null) return;
        
        if(mp.containsKey(l)) {
            Pair<Integer, Long> t = mp.get(l);
            
            Pair<Integer, Long> p = new Pair<>(1 + t.getKey(), root.val + t.getValue());
            
            mp.put(l, p);
            
        } else {
            Pair<Integer, Long> p = new Pair<Integer, Long>(1, (long)root.val);
            mp.put(l, p);
        }
        
        util(root.left, l+1);
        util(root.right, l+1);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        mp = new TreeMap<>();
        util(root, 0);
        List<Double> ans = new ArrayList<>();
        for(Integer itr : mp.keySet()) {
            Pair<Integer, Long> p = mp.get(itr);
            ans.add(
                (p.getValue().doubleValue()) / p.getKey()
            );
        }
        return ans;
    }
}