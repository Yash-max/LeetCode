class Solution {
    public int giveChunksCount(int []arr, int n, int x) {
        int chunks = 1;
        int currSum = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > x) return -1;
            if(currSum + arr[i] <= x) {
                currSum += arr[i];
            } else {
                chunks++;
                currSum = arr[i];
            }
        }
        return chunks;
    }
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;
        int sum = arr[0];
        int max = 0;
        
        for(int i = 1; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        int l = max;
        int r = sum;
        
        int ans = n;
        
        // System.out.println(l + " " + r + " " + giveChunksCount(arr, n, 488));
        
        while(l <= r) {
            
            int m = l + (r-l) / 2;
            int x = giveChunksCount(arr, n, m);
            
            if(x != -1 && x <= days) {
                // System.out.println(l + " " + r + " " + m + " " + x);
                ans = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
            
        return ans;
    }
}