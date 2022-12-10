//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string buildLowestNumber(string num, int k);
// Driver program to test above function
int main()
{
    int t,n;
    string str;
    cin>>t;
    while(t--)
    {
    cin>>n;
    cin>>str;
    cout << buildLowestNumber(str, n)<<endl;
    }
    return 0;
}

// } Driver Code Ends


string buildLowestNumber(string num, int k)
{
    int n = num.length();
    if(n <= k) return "0";
    
    string ans = "";
    
    stack<int> s;
    int zero = 0;
    for(char ch : num) {
        if(k == 0) {
            if(ch == '0') zero++;
            s.push(ch-'0');
        } else if(s.empty() || s.top() <= (ch-'0')) {
            if(ch == '0') zero++;
            s.push(ch-'0');
        } else {
            while(k > 0 && !s.empty() && s.top() > (ch-'0')) {
                s.pop();
                k--;
            }
            if(ch == '0') zero++;
            s.push(ch-'0');
        }
    }
    
    while(k > 0) {
        s.pop();
        k--;
    }
    
    if(s.size() == zero) return "0";
    
    stack<int> rev;
    
    while(!s.empty()) {
        rev.push(s.top());
        s.pop();
    }
    
    while(!rev.empty() && rev.top() == 0) {
        rev.pop();
    }
    
    while(!rev.empty()) {
        ans += to_string(rev.top());
        rev.pop();
    }
    
    if(ans == "") return "0";
    return ans;
}