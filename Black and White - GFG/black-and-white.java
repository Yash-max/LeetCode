//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static int conflictingMoves(int r, int c, int x, int y) {
        int ans = 0;
        if(x+2 < r && y+1 < c) {
            ans++;
        }
        if(x+2 < r && y-1 >= 0) {
            ans++;
        }
        if(x-2 >= 0 && y+1 < c) {
            ans++;
        }
        if(x-2 >= 0 && y-1 >= 0) {
            ans++;
        }
        if(y+2 < c && x+1 < r) {
            ans++;
        }
        if(y+2 < c && x-1 >= 0) {
            ans++;
        }
        if(y-2 >= 0 && x+1 < r) {
            ans++;
        }
        if(y-2 >= 0 && x-1 >= 0) {
            ans++;
        }
        return ans;
    }
    static long numOfWays(int n, int m)
    {
        long ans = 0;
        int total = n*m;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = (ans + total-1-conflictingMoves(n, m, i, j)) % 1000000007;
            }
        }
        return ans;
    }
}