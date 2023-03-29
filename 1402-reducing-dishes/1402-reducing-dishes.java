class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int n = satisfaction.length;
        int num = 0, sum = 0, curr = 0;
        
        for(int i = n-1; i >= 0; i--) {
            sum += satisfaction[i];
            curr += sum;
            if(curr > ans) {
                ans = curr;
            }
        }
        
        return ans;
    }
}