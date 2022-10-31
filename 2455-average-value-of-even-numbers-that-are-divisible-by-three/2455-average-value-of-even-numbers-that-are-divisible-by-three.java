class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int num = 0;
        for(int x : nums) {
            if(x % 6 == 0) {
                sum += x;
                num++;
            }
        }
        if(num == 0) return 0; 
        return sum / num;
    }
}