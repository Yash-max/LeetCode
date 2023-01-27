//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
	    bool isValid(char l, char r) {
	        if((l == '1') || (l == '2' && r < '7')) {
	            return true;
	        }
	        return false;
	    }
	    bool isValid(char ch) {
	        if(ch == '0') {
	            return false;
	        }
	        return true;
	    }
	    int util(string str, int n, int dp[]) {
	        if(n == 0) {
	            return 1;
	        }
	        if(dp[n] != -1) return dp[n];
	        long long ans = 0;
		    if(isValid(str[n-1])) 
		        ans = (ans + util(str, n-1, dp)) % 1000000007;
		    if(n > 1 && isValid(str[n-2], str[n-1])) 
		        ans = (ans + util(str, n-2, dp)) % 1000000007;
		    return dp[n] = ans;
	    }
		int CountWays(string str){
		    int n = str.length();
		    int dp[n+1];
		    for(int i = 0; i <= n; i++) {
		        dp[i] = -1;
		    }
		    long long ans = 0;
		    if(isValid(str[n-1])) ans = (ans + util(str, n, dp)) % 1000000007;
		    else if(n > 1 && isValid(str[n-2], str[n-1])) ans = (ans + util(str, n, dp)) % 1000000007;
		    return ans;
		}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution obj;
		int ans = obj.CountWays(str);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends