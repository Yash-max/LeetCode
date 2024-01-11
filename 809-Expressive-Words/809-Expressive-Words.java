class Solution {
    public boolean isExpressive(String s, String w) {
        int n = s.length();
        int m = w.length();
        if(n < m) {
            return false;
        } else if(n == m) {
            return (s.equals(w));
        } else {
            int i = 0, j = 0;
            while(i < n && j < m) {
                if(s.charAt(i) == w.charAt(j)) {
                    int lcnt = 0, rcnt = 0;
                    char ch = s.charAt(i);
                    while(i < n && s.charAt(i) == ch) {
                        lcnt++;
                        i++;
                    }
                    while(j < m && w.charAt(j) == ch) {
                        rcnt++;
                        j++;
                    }
                    // System.out.println(ch + " : " + lcnt + " - " + rcnt);
                    if((lcnt < rcnt) || (lcnt > rcnt && lcnt < 3)) {
                        return false;
                    }
                } else return false;
            }
            return (i == n && j == m);
        }
    }
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word: words) {
            // System.out.println();
            if(isExpressive(s, word)) {
                ans++;
            }
        }
        return ans;
    }
}

/*

"dddiiiinnssssssoooo"
"dinnssoo"
"ddinso"
"ddiinnso"
"ddiinnssoo"
"ddiinso"
"dinsoo"
"ddiinsso"
"dinssoo"
"dinso"

3


"abcd"
["abc"]

0
*/