class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        
        if(n == 1) {
            return matrix[0][0];
        }
        
        int ans = Integer.MAX_VALUE;
        
        int [][]dp = new int[n][n];
        
        dp[0] = matrix[0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                } else if(j == n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1]));
                }
                
                if(i == n-1) {
                    ans = Math.min(ans, dp[i][j]);
                }
                
            }
        }
        
        return ans;
    }
}