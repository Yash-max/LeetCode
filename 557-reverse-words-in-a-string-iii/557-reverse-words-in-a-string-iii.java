class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0, n = s.length();
        while(i < n) {
            j = i;
            
            while(j < n && s.charAt(j) != ' ') {
                j++;
            }
            
            for(int x = j-1; x >= i; x--) {
                ans.append(s.charAt(x));    
            }
            
            if(j != n) ans.append(' ');
            i = j+1;
        }
        return new String(ans);
    }
}