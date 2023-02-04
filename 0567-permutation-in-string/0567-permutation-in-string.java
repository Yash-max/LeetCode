class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[] charCount = new int[26];
        for(char ch : s1.toCharArray())
            charCount[ch - 'a']++;

        int l = 0, r = 0, totalCount = s1Len;
        while(r < s2.length()){
            if(charCount[s2.charAt(r++) - 'a']-- > 0)
                totalCount--;
            if(totalCount == 0)
                return true;
            if( r - l == s1Len && charCount[s2.charAt(l++) - 'a']++ >= 0)
                totalCount++;
        }
        return false;
    }
}