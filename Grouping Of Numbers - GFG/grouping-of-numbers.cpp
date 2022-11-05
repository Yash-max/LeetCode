//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int maxGroupSize(int arr[], int N, int K) {
        if(N == 1) return 1;
        vector<int> v(K, 0);
        for(int i = 0; i < N; i++) {
            v[arr[i] % K]++;
        }
        
        int ans = 0;
        for(int i = 1; i < (K+1)/2; i++) {
            //cout << i << " " << K-i << "\n"; 
            ans += max(v[i], v[K-i]);
        }
        if(v[0] > 0) ans++;
        if(K % 2 == 0 && v[K / 2] > 0) ans++;
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N,K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution ob;
        cout << ob.maxGroupSize(arr,N,K) << endl;
    }
    return 0;
}
// } Driver Code Ends