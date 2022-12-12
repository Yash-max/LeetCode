//{ Driver Code Starts
// Initial Template for Java
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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    
    int time = 0;
    
    void ArtDFS(ArrayList<ArrayList<Integer>> adj, int u, int parent, boolean[] vis, boolean[] isAP, int[] dis, int[] low) {
        
        int children = 0;
        vis[u] = true;
        
        dis[u] = low[u] = ++time;
        
        for(int v : adj.get(u)) {
            if(!vis[v]) {
                children++;
                ArtDFS(adj, v, u, vis, isAP, dis, low);
                low[u] = Math.min(low[u], low[v]);
                if(parent != -1 && low[v] >= dis[u]) {
                    isAP[u] = true;
                }
            } else if(v != parent) {
                low[u] = Math.min(low[u], dis[v]);
            }
        }
        if(parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
    
        time = 0;
        boolean []vis = new boolean[V];
        boolean []isAP = new boolean[V];
        int []dis = new int[V];
        int []low = new int[V];
        for(int u = 0; u < V; u++) {
            if(!vis[u]) {
                ArtDFS(adj, u, -1, vis, isAP, dis, low);
            }
        }
        
        for(int u = 0; u < V; u++) {
            if(isAP[u]) {
                ans.add(u);
            }
        }
        
        if(ans.size() == 0) ans.add(-1);
        return ans;
    }
}