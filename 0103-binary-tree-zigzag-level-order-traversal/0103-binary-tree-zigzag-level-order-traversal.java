class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        if(root == null) return ans;
        
        dq.addFirst(root);
        boolean flag = true;
        
        while(!dq.isEmpty()) {
            
            int n = dq.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                TreeNode itr = null;
                if(flag) {
                    itr = dq.removeFirst();
                } else {
                    itr = dq.removeLast();
                }
                list.add(itr.val);
                if(flag) {
                    if(itr.left != null) dq.addLast(itr.left);
                    if(itr.right != null) dq.addLast(itr.right);
                } else {
                    if(itr.right != null) dq.addFirst(itr.right);
                    if(itr.left != null) dq.addFirst(itr.left);
                }
            }
            
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}