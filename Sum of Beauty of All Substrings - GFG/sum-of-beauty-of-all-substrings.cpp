//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int beautySum(string s) {
        int ans = 0;
        int length = s.size();
        
        for(int left = 0; left < length; left++) {
            vector<int> freq(26, 0);
            for(int right = left; right < length; right++) {
                int maxF = 0, minF = length - left;
                
                freq[s[right]-'a']++;
                for(int i = 0; i < 26; i++) {
                    maxF = max(maxF, freq[i]);
                    if(freq[i] != 0) minF = min(minF, freq[i]);
                }
                ans += maxF - minF;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.beautySum(s) << endl;
    }
    return 0;
}
// } Driver Code Ends