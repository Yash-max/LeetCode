class Solution {
    public int[] findErrorNums(int[] nums) {
        int []ans = new int[2];
        int n = nums.length;
        int []map = new int[n+1];
        for(int x : nums) {
            map[x]++;
        }
        for(int i = 1; i <= n; i++) {
            if(map[i] == 2) ans[0] = i;
            if(map[i] == 0) ans[1] = i;
        }
        return ans;
    }
}