class Solution {
    public boolean isPallin(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public String util(int base, int n)
        {
            String res = "";
            while (n > 0) {
                char ch = '0';
                int num = n % base;
                
                if (num >= 0 && num <= 9)
                    ch = (char)(num + '0');
                else
                    ch = (char)(num - 10 + 'A');
                
                res += ch;
                n /= base;
            }
            return res;
        }
                             
    public boolean isStrictlyPalindromic(int n) {
        for(int b = 2; b <= n-2; b++) {
            if(isPallin(util(b, n)) == false) {
                return false;
            }
        }
        return true;
    }
}