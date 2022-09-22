class Solution {
    public String reverseWords(String s) {
        String ans = "";
        int i = 0, j = 0, n = s.length();
        while(i < n) {
            j = i;
            
            while(j < n && s.charAt(j) != ' ') {
                j++;
            }
            
            for(int x = j-1; x >= i; x--) {
                ans += s.charAt(x);    
            }
            
            if(j != n) ans += " ";
            i = j+1;
        }
        return ans;
    }
}