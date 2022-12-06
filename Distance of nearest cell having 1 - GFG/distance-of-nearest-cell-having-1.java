//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        
        int [][]ans = new int[r][];
        boolean [][]vis = new boolean[r][];
        
        for(int i = 0; i < r; i++) {
            ans[i] = new int[c];
            vis[i] = new boolean[c];
            Arrays.fill(ans[i], 2*r*c);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    ans[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[]arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int d = arr[2]+1;
            if(x-1 >= 0 && !vis[x-1][y]) {
                vis[x-1][y] = true;
                ans[x-1][y] = d;
                q.add(new int[]{x-1, y, d});
            }
            if(x+1 < r && !vis[x+1][y]) {
                vis[x+1][y] = true;
                ans[x+1][y] = d;
                q.add(new int[]{x+1, y, d});
            }
            if(y-1 >= 0 && !vis[x][y-1]) {
                vis[x][y-1] = true;
                ans[x][y-1] = d;
                q.add(new int[]{x, y-1, d});
            }
            if(y+1 < c && !vis[x][y+1]) {
                vis[x][y+1] = true;
                ans[x][y+1] = d;
                q.add(new int[]{x, y+1, d});
            }
        }
        
        return ans;
    }
}