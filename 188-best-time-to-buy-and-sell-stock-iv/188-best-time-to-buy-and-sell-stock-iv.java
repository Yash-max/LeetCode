class Solution {
    public int util(int []prices, int i, int n, int k, int b, int[][][] dp) {
        
        if(k == 0 || i == n) return 0;
        if(dp[i][k][b] != -1) return dp[i][k][b];
        int ans = 0;
        for(int x = i; x < n; x++) {
            if(b == 1) {
                ans = Math.max(ans, util(prices, x+1, n, k, 0, dp) - prices[x]);
            } else {
                ans = Math.max(ans, util(prices, x+1, n, k-1, 1, dp) + prices[x]);
            }
        }
        return dp[i][k][b] = ans;
    }
    public int maxProfit(int k, int[] prices) {
        int ans = 0;
        int n = prices.length;
        if(k == 0 || n < 2) return ans;
        int buy = prices[0];
        
        int[][][] dp = new int[n+1][][];
        
        for(int i = 0; i <= n; i++) {
            dp[i] = new int[k+1][];
            for(int j = 0; j <= k; j++) {
                dp[i][j] = new int[3];
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return util(prices, 0, n, k, 1, dp);
    }
}