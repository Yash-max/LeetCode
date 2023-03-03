class Solution {
    public int strStr(String haystack, String needle) {
        int ans = -1;
        int n = haystack.length();
        int m = needle.length();
        
        for(int i = 0; i <= n-m; i++) {
            boolean isFound = true;
            
            for(int j = 0; j < m; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    isFound = false;
                    break;
                }
            }
            
            if(isFound) {
                return i;
            }
        }
        
        return ans;
    }
}