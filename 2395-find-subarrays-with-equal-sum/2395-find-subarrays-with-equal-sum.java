class Solution {
    public boolean findSubarrays(int[] arr) {
        int n = arr.length;
        if(n <= 2) return false;
        for(int i = 0; i < n-1; i++) {
            long x = arr[i] + arr[i+1];
            for(int j = i+1; j < n-1; j++) {
                if(arr[j] + arr[j+1] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}