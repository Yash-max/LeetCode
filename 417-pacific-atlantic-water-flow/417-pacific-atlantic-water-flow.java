class Solution {
    int r, c;
    int [][]mat;
    
    public void dfs(int i, int j, int [][]vis) {
        if(vis[i][j] != -1) return;
        vis[i][j] = 1;        
        if(i > 0 && mat[i][j] <= mat[i-1][j]) {
            dfs(i-1, j, vis);
        }
        if(j > 0 && mat[i][j] <= mat[i][j-1]) {
            dfs(i, j-1, vis);
        }
        if(i < r-1 && mat[i][j] <= mat[i+1][j]) {
            dfs(i+1, j, vis);
        }
        if(j < c-1 && mat[i][j] <= mat[i][j+1]) {
            dfs(i, j+1, vis);
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        r = arr.length;
        c = arr[0].length;
        mat = arr;
        
        int [][]pacific  = new int[r][];
        int [][]atlantic = new int[r][];
        
        for(int i = 0; i < r; i++) {
            pacific[i] = new int[c];
            atlantic[i] = new int[c];
            
            Arrays.fill(pacific[i], -1);
            Arrays.fill(atlantic[i], -1);
        }
        
        for(int i = 0; i < r; i++) {
            if(pacific[i][0] == -1) {
                dfs(i, 0, pacific);
            }
            if(atlantic[i][c-1] == -1) {
                dfs(i, c-1, atlantic);
            }
        }
        
        for(int j = 0; j < c; j++) {
            if(pacific[0][j] == -1) {
                dfs(0, j, pacific);
            }
            if(atlantic[r-1][j] == -1) {
                dfs(r-1, j, atlantic);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}