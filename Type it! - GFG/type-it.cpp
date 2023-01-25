//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    bool isPalindrome(string &s, int l, int r) {
        for(int i = l, j = r; i >= 0; i--, j--) {
            if(s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
    
    int util(string &s, int n, bool canHalf) {
        if(n == 0) {
            return 1;
        }
        int ans = 2*(n+n);
        if(canHalf && (n+1) % 2 == 0 && isPalindrome(s, n/2, n)) {
            ans = 1 + util(s, n/2, false);
        }
        ans = min(ans, 1 + util(s, n-1, canHalf));
    }
    int minOperation(string s) {
        int n = s.length();
        return util(s, n-1, true);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.minOperation(s) << "\n";
    }
    return 0;
}

// } Driver Code Ends