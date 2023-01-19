//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int carpetBox(int A, int B, int C, int D){
        int left = 0;
        
        int a = A;
        int b = B;
        int c = C;
        int d = D;
        
        while(a > c) {
            a >>= 1;
            left++;
        }
        
        while(b > d) {
            b >>= 1;
            left++;
        }
        
        int right = 0;
        
        a = A;
        b = B;
        c = C;
        d = D;
        
        while(a > d) {
            a >>= 1;
            right++;
        }
        
        while(b > c) {
            b >>= 1;
            right++;
        }
        
        return min(left, right);
    }
};


//{ Driver Code Starts.


int main(){
    int t;
    cin>>t;
    while(t--){
        int A,B,C,D;
        cin>>A>>B>>C>>D;
        
        Solution ob;

        int ans = ob.carpetBox(A,B,C,D);
        
        cout<<ans<<endl;
    }
}
// } Driver Code Ends