class Solution {
public:
    void dfs(vector<vector<int>>& rooms, vector<bool> &vis, int i) {
        vis[i] = true;
        for(auto itr : rooms[i]) {
            if(vis[itr] == false) {
                dfs(rooms, vis, itr);
            }
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> vis(n, false);
        dfs(rooms, vis, 0);
        for(int i = 0; i < n; i++) {
            if(vis[i] == false) return false;
        }
        return true;
    }
};