class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n < 3) return n;
        int []mp = new int[n];
        int ans = 0;
        int count = 0;
        
        int current = 0;
        int i = 0, j = 0;
        
        while(j < n) {
            
            if(mp[fruits[j]] == 0) {
                current++;
            }
            
            mp[fruits[j]]++;
            count++;
            j++;
            
            if(current > 2) {
                while(i < j && current > 2) {
                    mp[fruits[i]]--;
                    if(mp[fruits[i]] == 0) {
                        current--;
                    }
                    count--;
                    i++;
                }
            } else {
                ans = Math.max(ans, count);
            }
        }
        
        
        return ans;
    }
}