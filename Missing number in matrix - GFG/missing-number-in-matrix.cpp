//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    long long int MissingNo(vector<vector<int> >& matrix) {
        int x = -1, y = -1, n = matrix.size();
        
        long long leftDiagonal = 0;
        long long rightDiagonal = 0;
        
        vector<long long> rowSum(n);
        vector<long long> colSum(n);
        
        for(int i = 0; i < n; i++) {
            
            leftDiagonal  += matrix[i][i];
            rightDiagonal += matrix[i][n-i-1];
            
            for(int j = 0; j < n; j++) {
                
                rowSum[i] += matrix[i][j];
                colSum[j] += matrix[i][j];
                
                if(matrix[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        
        if(rowSum[x] != colSum[y]) {
            return -1;
        }
        
        if((x == y) && x == (n-1-y) && (leftDiagonal != rightDiagonal)) {
            return -1;
        }
        
        long long l = 0, r = 0;
        
        if(x != 0) {
            l = rowSum[0]-rowSum[x];
        } else {
            l= rowSum[1]-rowSum[x];
        }
        
        if(y != 0) {
            r = colSum[0]-colSum[y];
        } else {
            r = colSum[1]-colSum[y];
        }
        
        if(l != r || l <= 0) return -1;
        
        long long k = l;
        
        rowSum[x] += k;
        colSum[y] += k;
        
        if(x == y) {
            leftDiagonal += k;
        }
        
        if(x == n-1-y) {
            rightDiagonal += k;
        }
        
        if(leftDiagonal != rightDiagonal) {
            return -1;
        }
        
        for(int i = 0; i < n-1; i++) {
            if(rowSum[i] != rowSum[i+1]) {
                return -1;
            }
            if(colSum[i] != colSum[i+1]) {
                return -1;
            }
            if(rowSum[i] != colSum[i]) {
                return -1;
            }
            if(rowSum[i] != colSum[i]) {
                return -1;
            }
            if(rowSum[i] != leftDiagonal) {
                return -1;
            }
        }
        return k;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>> matrix(n, vector<int>(n,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> matrix[i][j];
			}
		}
		Solution ob;
		long long int ans = ob.MissingNo(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends