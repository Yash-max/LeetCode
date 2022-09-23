class Solution {
    public int concatenatedBinary(int n) {
        int m = 1000000007;
        long ans = 0;
        int l = 0;
        
        for(int i = 1; i <= n; i++) {
            if((i & (i-1)) == 0) l++;
            ans = (ans << l | i) % m;
        }
        
        return (int)ans;
    }
}