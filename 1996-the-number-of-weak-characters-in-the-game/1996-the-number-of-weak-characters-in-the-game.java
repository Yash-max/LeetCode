class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        int[] arr = new int[100002];
        for(int[] x: p) {
            arr[x[0]] = Math.max(arr[x[0]], x[1]);
        }
        for(int i = 100000; i >= 0; i--) {
            arr[i] = Math.max(arr[i+1], arr[i]);
        }
        
        int ans = 0;
        
        for(int[] x : p) {
            if(x[1] < arr[x[0]+1]) {
                ans++;
            }
        }
        
        return ans;
    }
}