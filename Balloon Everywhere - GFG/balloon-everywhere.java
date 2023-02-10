//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int []freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        return Math.min(freq['n'-'a'], 
                Math.min(
                    Math.min(freq['b'-'a'], freq['a'-'a']), 
                    Math.min(freq['l'-'a'], freq['o'-'a'])/2
                )
            );
    }
}