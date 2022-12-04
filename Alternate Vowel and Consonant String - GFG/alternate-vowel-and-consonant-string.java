//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int nextVowel(int x){
        if(x == 0) {
            return 4;
        }
        if(x == 4) {
            return 8;
        }
        if(x == 8) {
            return 14;
        }
        if(x == 14) {
            return 20;
        }
        return 26;
    }
    public int nextConsonant(int x){
        while(x < 26) {
            x++;
            if(x != 4 && x != 8 && x != 14 && x != 20) {
                return x;
            }
        }
        return x;
    }
    public String rearrange(String s, int n){
        StringBuilder sb = new StringBuilder();
        int v = 0, c = 0;
        int []mp = new int[26];
        
        for(char ch : s.toCharArray()) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mp[ch-'a']++;
                v++;
            } else {
                mp[ch-'a']++;
                c++;
            }
        }
        
        if(Math.abs(v-c) > 1) {
            return "-1";
        }
        
        boolean flag = true;
        if(c > v) flag = false;
        
        int i = 0;
        int j = 1;
        
        while(i < 26 || j < 26) {
            if(flag) {
                while(i < 26 && mp[i] == 0) {
                    i = nextVowel(i);
                }
                if(i < 26 && mp[i] > 0) {
                    sb.append((char)(i+'a'));
                    mp[i]--;
                }
                // System.out.println(sb.toString());
            } else {
                while(j < 26 && mp[j] == 0) {
                    j = nextConsonant(j);
                }
                if(j < 26 && mp[j] > 0) {
                    sb.append((char)(j+'a'));
                    mp[j]--;
                }
                // System.out.println(sb.toString());
            }
            
            if(i >= 26 || j >= 26) break;
            
            flag = !flag;
        }
        
        return sb.toString();
    }
}