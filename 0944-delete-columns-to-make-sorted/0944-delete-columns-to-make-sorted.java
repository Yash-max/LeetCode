class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int r = strs.length;
        int c = strs[0].length();
        for(int col = 0; col < c; col++) {
            boolean isSorted = true;
            char prev = strs[0].charAt(col);
            for(int row = 1; row < r; row++) {
                if(strs[row].charAt(col) < prev) {
                    isSorted = false;
                    break;
                }
                prev = strs[row].charAt(col);
            }
            if(!isSorted) {
                ans++;
            }
        }
        return ans;
    }
}