//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        int l = 0, r = -1;
        int curr = 0, max = 0;;
        int []arr = new int[2];
        arr[0] = 0; arr[1] = 0;
        
        // 1 00 111 00000 1 000000000
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            r = i;
            if(str.charAt(i) == '0') {
                flag = true;
                curr++;
            } else {
                curr--;
                if(curr < 0) {
                    curr = 0;
                    l = i+1;
                }
            }
            if(r >= l && curr > max) {
                max = curr;
                arr[0] = l;
                arr[1] = r;
                // System.out.println(i + " " + arr[0] + " " + arr[1]);
            }
        }
        
        Vector<Integer> ans = new Vector<>();
        if(!flag) ans.add(-1);
        else {
            ans.add(arr[0]+1);
            ans.add(arr[1]+1);
        }
        return ans;
    }
}