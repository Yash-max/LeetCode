//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void makeVis(int i, int j, int N, int M, int [][]mat, int [][]vis) {
        // System.out.println(i + " " + j);
        vis[i][j] = 1;
        
        if(i-1 >= 0 && mat[i][j] <= mat[i-1][j] && vis[i-1][j] == 0) {
            makeVis(i-1, j, N, M, mat, vis);
        }
        
        if(i+1 < N && mat[i][j] <= mat[i+1][j] && vis[i+1][j] == 0) {
            makeVis(i+1, j, N, M, mat, vis);
        }
        
        if(j-1 >= 0 && mat[i][j] <= mat[i][j-1] && vis[i][j-1] == 0) {
            makeVis(i, j-1, N, M, mat, vis);
        }
        
        if(j+1 < M && mat[i][j] <= mat[i][j+1] && vis[i][j+1] == 0) {
            makeVis(i, j+1, N, M, mat, vis);
        }
    }
	int water_flow(int [][] mat, int N, int M) {
		
		int [][]indianOceanVis = new int[N][M];
		int [][]indianSeaVis   = new int[N][M];
		
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
		    for(int j = 0; j < M; j++) {
		        if((i == 0 || j == 0) && indianOceanVis[i][j] == 0) {
		            makeVis(i, j, N, M, mat, indianOceanVis);    
		        }
		        if((i == N-1 || j == M-1) && indianSeaVis[i][j] == 0) {
		            makeVis(i, j, N, M, mat, indianSeaVis);    
		        }
		    }
		}
		
		for(int i = 0; i < N; i++) {
		    for(int j = 0; j < M; j++) {
		      //  System.out.println(indianOceanVis[i][j] + " " + indianSeaVis[i][j]);
		        if(indianOceanVis[i][j] == 1 && indianSeaVis[i][j] == 1) {
		            ans++;
		        }
		    }
		}
		
		return ans;
	}
}