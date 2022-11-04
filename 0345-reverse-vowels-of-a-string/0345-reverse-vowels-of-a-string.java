class Solution {
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'A' || 
           ch == 'e' || ch == 'E' || 
           ch == 'i' || ch == 'I' || 
           ch == 'o' || ch == 'O' || 
           ch == 'u' || ch == 'U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = s.length()-1;
        while(i < j) {
            while(i < j && !isVowel(sb.charAt(i))) {
               i++;
            }
            while(i < j && !isVowel(sb.charAt(j))) {
               j--;
            }
            if(i < j) {
                char prev = sb.charAt(i);
                char next = sb.charAt(j);
                sb.setCharAt(i, next);
                sb.setCharAt(j, prev);
                i++; j--;
            }
        }
        return sb.toString();
    }
}