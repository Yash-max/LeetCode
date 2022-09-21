class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int x : nums) {
            if(x % 2 == 0) sum += x;
        }
        
        int[] ans = new int[queries.length];
        
        int i = 0;
        
        for(int[] x : queries) {
            int prev = nums[x[1]];
            
            int next = prev + x[0];
            
            if(prev % 2 == 0) {
                sum -= prev;
            }
            
            if(next % 2 == 0) {
                sum += next;
            }
            
            nums[x[1]] = next;
            
            ans[i] = sum;
            
            i++;
            
        }
        
        return ans;
    }
}