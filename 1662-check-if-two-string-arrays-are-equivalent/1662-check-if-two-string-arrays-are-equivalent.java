class Solution {
    public boolean arrayStringsAreEqual(String[] a, String[] b) {
        int i = 0, j = 0;
        int lw = 0, rw = 0;
        int n = a.length, m = b.length;
        while(lw < n && rw < m) {
            if(a[lw].charAt(i) != b[rw].charAt(j)) {
               return false; 
            }
            i++; j++;
            if(i == a[lw].length()) {
                i = 0;
                lw++;
            }
            if(j == b[rw].length()) {
                j = 0;
                rw++;
            }
        }
        if(lw < n && i < a[lw].length()) {
            return false;
        }
        if(rw < m && j < b[rw].length()) {
            return false;
        }
        return true;
    }
}