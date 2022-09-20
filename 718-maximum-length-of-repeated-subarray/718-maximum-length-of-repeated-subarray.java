class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                if (A[i] == B[j]) {
                    dp[i][j] = ((i > 0 && j > 0) ? dp[i-1][j-1] : 0) + 1;
                    if (ans < dp[i][j]) ans = dp[i][j];
                }
            }
        }
        return ans;
    }
}