//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	long long int NoOfChicks(int n){
	    
	   vector<long long> dp(n+1 , 0);
	   vector<long long> produced(n+1 , 0);
	    produced[1] = 1;
	    dp[1] = 1;
	    for (int i = 2 ; i<=n ; i++){
	        long long curr = dp[i-1] - (i-6 >= 0 ? produced[i-6] : 0);
	        produced[i] = 2 * curr;
	        dp[i] = curr * 3;
	    }
	    return dp[n];
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution obj;
		long long int ans = obj.NoOfChicks(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends