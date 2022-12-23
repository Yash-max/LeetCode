class Solution {
    int n;
    int[] arr;
    int[][] dp;
    public int util(int i, boolean canBuy) {
        if(i >= n) {
            return 0;
        }
        
        if(dp[i][(canBuy?1:0)] != -1) {
            return dp[i][(canBuy?1:0)];    
        }
        
        int ans = 0, take = 0, noTake = 0, give = 0, noGive = 0;
    
        if(canBuy == true) {
            take   = util(i+1, false) - arr[i];
            noTake = util(i+1, true);
        } else {
            give   = util(i+2, true) + arr[i];
            noGive = util(i+1, false);
        }
        ans = Math.max(Math.max(take, noTake), Math.max(give, noGive));
        return dp[i][(canBuy?1:0)] = ans;
    }
    
    public int maxProfit(int[] prices) {
        n = prices.length;
        if(n < 2) return 0;
        arr = prices;
        dp = new int[n+1][2];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 2; j++) {
                dp[i][j]= -1;
            }
        }
        
        return util(0, true);
    }
}