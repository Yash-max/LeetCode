//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    int numInBase(long long n, int b) {
        int ans = 0;
        while(n != 0) {
            ans++;
            n /= b;
        }
        // cout << b << " " << ans << '\n';
        return ans;
    }
    string baseEquiv(int n, int m){
        for(int base = 2; base <= 32; base++) {
            if(numInBase(n, base) == m) {
                return "Yes";
            }
        }
        return "No";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        Solution ob;
        cout<<ob.baseEquiv(n,m)<<endl;
    }
    return 0;
}

// } Driver Code Ends