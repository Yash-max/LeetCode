class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int prev = 0, end = 0, ans = 0;
        
        for(int i = 0; i < n-1; i++) {
            if(i + nums[i] > end) {
                end = i + nums[i];
            }
            if(i == prev) {
                ans++;
                prev = end;
            }
        }
        
        return ans;
    }
}