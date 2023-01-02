class Solution {
    
    public boolean wordPattern(String pattern, String s) {
        
        String []arr = s.split(" ");
        
        if(arr.length != pattern.length()) return false;
        
        int n = arr.length;
        
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            if(charToStr.containsKey(pattern.charAt(i)) && !charToStr.get(pattern.charAt(i)).equals(arr[i])) {
                return false;
            }
            if(strToChar.containsKey(arr[i]) && !strToChar.get(arr[i]).equals(pattern.charAt(i))) {
                return false;
            }
            
            charToStr.put(pattern.charAt(i), arr[i]);
            strToChar.put(arr[i], pattern.charAt(i));
            
        }
        
        return true;
    }
}