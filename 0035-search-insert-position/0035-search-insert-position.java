class Solution {
    public int binarySearch(int[] nums, int l, int r, int x) {
        int temp = -1;
        if(l <= r) {
            int m = l+(r-l)/2;
            if(nums[m] == x) {
                temp = m;
            } else if(nums[m] > x) {
                temp = binarySearch(nums, l, m-1, x);
                if(temp == -1) {
                    temp = m;
                }
            } else {
                temp = binarySearch(nums, m+1, r, x);    
                if(temp == -1) {
                    temp = m+1;
                }
            }
        }
        return temp;
    }
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(nums[0] > target) return 0;
        if(nums[n-1] < target) return n;
        return binarySearch(nums, 0, n-1, target);
    }
}