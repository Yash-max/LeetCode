class Solution {
    public int search(int[] nums, int x) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == x) {
                return m;
            } else if(nums[m] > x) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}