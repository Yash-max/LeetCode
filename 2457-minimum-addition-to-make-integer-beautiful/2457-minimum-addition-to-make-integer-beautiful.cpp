class Solution {
public:
    void addOne(vector<int> &v, int n) {
        int c = 1;
        for(int i = n-1; c != 0 && i >= 0; i--) {
            v[i]++;
            c = v[i] / 10;
            if(v[i] >= 10) {
                v[i] %= 10;       
            }
        }
    }
    
    long long makeIntegerBeautiful(long long n, int target) {
        vector<int> v;
        
        long long t = n;
        while(t > 0) {
            v.push_back(t % 10);
            t /= 10;
        }
        v.push_back(0);
        reverse(v.begin(), v.end());
        
        int itr = v.size()-1;
        
        while(accumulate(v.begin(), v.end(), 0) > target && itr != 0) {
            v[itr] = 0;
            // for(int x : v) cout << x << " ";
            // cout << '\n';
            addOne(v, itr);
            // for(int x : v) cout << x << " ";
            // cout << '\n';
            itr--;
        }
        
        long long ans = 0;
        for(int i = 0; i < v.size(); i++) {
            ans = ans * 10 + v[i];
        }
        return ans - n;
    }
};