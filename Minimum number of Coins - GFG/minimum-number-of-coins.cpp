//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> minPartition(int N)
    {
        vector<int> dp(N+1, 0);
        vector<int> listOfDeno = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int numberOfDeno = 10;
        for(int i = 1; i <= N; i++) {
            dp[i] = i;
            for(int j = 0; j < numberOfDeno; j++) {
                if(i-listOfDeno[j] >= 0) {
                    dp[i] = min(dp[i], 1 + dp[i-listOfDeno[j]]);
                } else break;
            }
        }
        vector<int> listOfDenoUsed;
        int amount = N;
        while(amount > 0) {
            int currentMin = dp[amount];
            for(int j = numberOfDeno-1; j >= 0; j--) {
                if(amount-listOfDeno[j] >= 0 && dp[amount-listOfDeno[j]] + 1 == currentMin) {
                    listOfDenoUsed.push_back(listOfDeno[j]);
                    amount -= listOfDeno[j];
                    break;
                }
            }
        }
        return listOfDenoUsed;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        vector<int> numbers = ob.minPartition(N);
        for(auto u: numbers)
            cout<<u<<" ";
        cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends