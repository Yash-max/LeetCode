class Solution {
public:
    void util(int num, int prev, int i, int &n, int k, vector<int> &ans) {
        if(i == n) {
            ans.push_back(num);
            return;
        }
        if(prev-k >= 0) {
            util(num*10+(prev-k), prev-k, i+1, n, k, ans);
        }
        if((prev-k) != (prev+k) && prev+k <= 9) {
            util(num*10+(prev+k), prev+k, i+1, n, k, ans);
        }
    }
    vector<int> numsSameConsecDiff(int n, int k) {
        vector<int> ans;
        for(int i = 1; i < 10; i++) {
            util(i, i, 1, n, k, ans);
        }
        return ans;
    }
};