class Solution {
public:
    int dfs(vector<pair<int, int>> adj[], int n, int p, int u, vector<bool> &vis) {
        if(vis[u]) return 10000;
        vis[u] = true;
        
        int ans = 10000;
        
        for(pair<int, int> list: adj[u]) {
            int v = list.first;
            int w = list.second;
            ans = min(ans, w);
            if(!vis[v] && v != p) {
                ans = min(ans, dfs(adj, n, u, v, vis));
            }
        }
        
        return ans;
    }
    int minScore(int n, vector<vector<int>>& roads) {
        int ans = 0;
        vector<pair<int, int>> adj[n];
        vector<bool> vis(n, false);
        
        for(vector<int> road : roads) {
            adj[road[0]-1].push_back({road[1]-1, road[2]});
            adj[road[1]-1].push_back({road[0]-1, road[2]});
        }
        
        return dfs(adj, n, -1, 0, vis);
    }
};