class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        
        long sum = 0;
        for(int x : nums) {
            sum += x;
        }
        
        long ans = Long.MAX_VALUE;
        int index = 0;
        
        long left = 0;
        long right = sum;
        
        for(int i = 0; i < n; i++) {
            left  += nums[i];
            right -= nums[i];
            
            long currAbs = left/(i+1);
            if(n-i-1 != 0) {
                currAbs -= right/(n-i-1);
            }
            
            // System.out.println(i + " " + left + " " + right + " " + Math.abs(currAbs));
            
            if(ans > Math.abs(currAbs)) {
                ans = Math.abs(currAbs);
                index = i;
            }
        }
        
        return index;
    }
}