class Solution {
    public boolean canConvert(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        
        if(n1 != n2) return false;
        
        int []map1 = new int[26];
        int []map2 = new int[26];

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);
        
        int unique1 = 0;
        int unique2 = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 0; i < n1; i++) {
            char ch1 = str1.charAt(i);
            if(map1[ch1-'a'] == -1) {
                map1[ch1-'a'] = unique1++;
            }
            sb1.append(map1[ch1-'a']);
            sb1.append("_");

            char ch2 = str2.charAt(i);
            if(map2[ch2-'a'] == -1) {
                map2[ch2-'a'] = unique2++;
            }
            sb2.append(map2[ch2-'a']);
            sb2.append("_");
        }
        // System.out.println(sb1.toString() + " " + sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }
}