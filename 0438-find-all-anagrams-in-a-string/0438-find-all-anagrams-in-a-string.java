class Solution {
    public boolean check(int[] text, int[] pattern) {
        for(int i = 0; i < 26; i++) {
            if(text[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n < m) return ans;
        
        int []pattern = new int[26];
        for(int i = 0; i < m; i++) {
            pattern[p.charAt(i)-'a']++;
        }
        
        int []current = new int[26];
        for(int i = 0; i < m; i++) {
            current[s.charAt(i)-'a']++;
        }
        
        if(check(current, pattern)) {
            ans.add(0);
        }
        
        for(int i = m , j = 1; i < n; i++, j++) {
            current[s.charAt(i-m)-'a']--;
            current[s.charAt(i)-'a']++;
            //System.out.println(s.charAt(i-m) + " " + s.charAt(i));
            if(check(current, pattern)) {
                ans.add(j);
            }
        }
        
        return ans;
    }
}