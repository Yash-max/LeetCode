class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0, temp = 0;
        
        int i = 0, j = tokens.length-1;
        
        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i++];
                temp++;
                ans = Math.max(ans, temp);
            } else if(temp > 0) {
                temp--;
                power += tokens[j--];
            } else {
                break;
            }
        }
        
        return ans;
    }
}