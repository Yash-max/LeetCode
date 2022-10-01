class Solution {
    
    int n;
    String arr;
    int []dp;
    
    int util(int i) {
        if(i >= n) {
            return 1;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int left = 0, right = 0;
        if(arr.charAt(i) != '0') {
            left = util(i+1);
        }
        if(i < n-1 && ((arr.charAt(i) == '1' && arr.charAt(i) <= '9') || (arr.charAt(i) == '2' && arr.charAt(i+1) <= '6'))) {
            right = util(i+2);
        }
        return dp[i] = left + right;
    }
    public int numDecodings(String s) {
        n = s.length();
        arr = s;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return util(0);
    }
}