//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int calcUtil(int arr[], int n, int dp[]) {
        if(n <= 0) {
            return 0;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int left = arr[n-1] + calcUtil(arr, n-2, dp);
        int right = calcUtil(arr, n-1, dp);
        return dp[n] = Math.max(left, right);
    }
    int findMaxSum(int arr[], int n) {
        int dp[] = new int[n+1];
        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return calcUtil(arr, n, dp);
    }
}