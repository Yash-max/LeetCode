class Solution {
    public int climbStairs(int n) {
        int prev = 1, prev_prev = 1;
        int ans = 1;
        for(int i = 2; i <= n; i++) {
            ans = prev + prev_prev;
            prev_prev = prev;
            prev = ans;
        }
        return ans;
    }
}