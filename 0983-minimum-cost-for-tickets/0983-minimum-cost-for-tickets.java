class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        
        Set<Integer> set = new HashSet<>();
        
        int maxDay = 0;
        
        for(int d : days) {
            set.add(d);
            maxDay = Math.max(maxDay, d);
        }
        
        int[] dp = new int[maxDay+1];
        
        int minCost = Math.min(costs[0], Math.min(costs[1], costs[2]));
        
        for(int i = 1; i <= maxDay; i++) {
            if(i > maxDay) break;
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = minCost + dp[i-1];    
            }
            
            dp[i] = Math.min(dp[i], costs[0] + dp[i-1]);
            
            if(i >= 7) {
                dp[i] = Math.min(dp[i], costs[1] + dp[i-7]);
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }
            
            if(i >= 30) {
                dp[i] = Math.min(dp[i], costs[2] + dp[i-30]);
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
        }
        
        return dp[maxDay];
    }
}