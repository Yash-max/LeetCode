class Solution {
    int mod = 1000000007;
    int [][]dp;
    int util(int n, int k, int x) {
        if(n == 0 && x == 0) return 1;
        if(x < 0 || n == 0) return 0;
        if(dp[n][x] != -1) return dp[n][x];
        int ans = 0;
        for(int i = 1; i <= k; i++) {
            ans = (ans + util(n-1, k, x-i)) % mod;
        }
        return dp[n][x] = ans % mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][];
        for(int i = 0; i <= n; i++) {
            dp[i] = new int[target+1];
            Arrays.fill(dp[i], -1);
        }
        return util(n, k, target);
    }
}