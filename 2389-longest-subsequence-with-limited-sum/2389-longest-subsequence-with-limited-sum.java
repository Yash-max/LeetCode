class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] ans = new int[queries.length];
        
        int sum = 0;
        for(int x : nums) sum += x;
        
        for(int i = 0; i < queries.length; i++) {
            
            int q = queries[i];
            
            if(q < nums[0]) {
                ans[i] = 0;
                continue;
            }
            
            if(q >= sum) {
                ans[i] = n;
                continue;
            }
            
            int l = 0, r = 0, temp = 0, len = 0;
            
            while(r < n) {
                temp += nums[r++];
                if(temp > q) {
                    len = Math.max(len, r-l-1);
                    while(l <= r && temp > q) {
                        temp -= nums[l];
                        l++;
                    }
                }
            }
            
            ans[i] = len;
            
        }
        
        return ans;
    }
}