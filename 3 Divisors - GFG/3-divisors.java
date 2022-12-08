//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static boolean isPrime(long n) {
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
               return false;
            }
        }
        return true;
    }
    static boolean isSquare(long n) {
        long x =  (long)Math.sqrt(n);
        if(x * x  == n) return true;
        return false;
    }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> ans = new ArrayList<>();
        for(Long x : query) {
            int temp = 0;
            for(long i = 2; i * i <= x; i++) {
                // System.out.print(i + " ");
                if(isPrime(i)) {
                    // System.out.println("Yes");
                    temp++;
                } else {
                    // System.out.println("No");
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}