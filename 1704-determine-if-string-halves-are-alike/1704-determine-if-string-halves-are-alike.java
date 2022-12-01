class Solution {
    public boolean halvesAreAlike(String s) {
        
        int []m1 = new int[26];
        int []m2 = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if(i < s.length()/2) {
                
                if(ch >= 'a') m1[ch-'a']++;
                
                else m1[ch-'A']++;
                
            } else {
                
                if(ch >= 'a') m2[ch-'a']++;
                
                else m2[ch-'A']++;
                
            }
        }
        
        int sum1 = m1[0]+m1[4]+m1[8]+m1[14]+m1[20];
        
        int sum2 = m2[0]+m2[4]+m2[8]+m2[14]+m2[20];
        
        if(sum1 != sum2){
            return false;
        }
        return true;
    }
}