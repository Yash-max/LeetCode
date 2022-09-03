class Solution {
    int ans;
    int[][] arr;
    int r, c;
    Set<Integer> set;
    
    public int check() {
        int ans = 0;
        for(int i = 0; i < r; i++) {
            int temp = 1;
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == 1 && !set.contains(j)) {
                    temp = 0;
                    break;
                }
            }
            ans += temp;
        }
        return ans;
    }
    
    public void util(int j, int x) {
        if(x == 0) {
            ans = Math.max(ans, check());
            return;
        }
        
        if(j == c) return;
        
        util(j+1, x);
        
        set.add(j);
        util(j+1, x-1);
        set.remove(j);
        
    }
    
    public int maximumRows(int[][] mat, int x) {
        r = mat.length;
        c = mat[0].length;
        
        if(c == x) return r;
        
        ans = 0;
        arr = mat;
        set = new HashSet<>();
        
        util(0, x);
        
        return ans;
    }
}