class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        for(int i = 0, j = n, k = 0; j < 2*n; i++, j++) {
            result[k++] = nums[i];
            result[k++] = nums[j];
        }
        return result;
    }
}