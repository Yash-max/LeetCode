class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[366];
        
        Set<Integer> set = new HashSet<>();
        
        // for(int d = 1; d <= 365; d++) {
        //     dp[d] = costs[0] * d;
        //     if(d >= 7) dp[d] = Math.min(dp[d], costs[1] + dp[d-7]);
        //     if(d >= 30) dp[d] = Math.min(dp[d], costs[2] + dp[d-30]);
        // }
        
        int maxDay = 0;
        
        for(int d : days) {
            set.add(d);
            maxDay = Math.max(maxDay, d);
        }
        
        int minCost = Math.min(costs[0], Math.min(costs[1], costs[2]));
        
        for(int i = 1; i <= 365; i++) {
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
        
        return dp[days[n-1]];
        /*
            [1,4,6,7,8,20]
            [7,2,15]
        */
    }
}