class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; ) {
            int count = 0;
            char ch = chars[i];
            while(i < n && chars[i] == ch) {
                count++;
                i++;
            }
            sb.append(ch);
            if(count != 1) sb.append(Integer.toString(count));
        }
        int ans = 0;
        int x = 0;
        for(char ch : sb.toString().toCharArray()) {
            chars[x++] = ch;
        }
        return x;
    }
}