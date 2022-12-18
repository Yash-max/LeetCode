class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& arr) {
        vector<int> v;
        stack<pair<int, int>> s;
        int n = arr.size();
        s.push({arr[n-1], n-1});
        v.push_back(0);
        for(int i = n-2; i >= 0; i--) {
            int temp = 0;
            while(!s.empty() && s.top().first <= arr[i]) {
                s.pop();
            }
            if(s.empty()) {
                v.push_back(0);
                s.push({arr[i], i});
            } else {
                v.push_back(s.top().second - i);
                s.push({arr[i], i});
            }
        }
        reverse(v.begin(), v.end());
        return v;
    }
};