class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        Map<Integer, Integer> mp = new TreeMap<>();
        int sum = 0;
        for(int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0)+1);
            if(x % 2 == 0) sum += x;
        }
        
        int[] ans = new int[queries.length];
        
        int i = 0;
        
        for(int[] x : queries) {
            int prev = nums[x[1]];
            if(mp.get(prev) == 1) {
                mp.remove(prev);
            } else {
                mp.put(prev, mp.get(prev)-1);
            }
            int next = prev + x[0];
            mp.put(next, mp.getOrDefault(next, 0)+1);
            
            if(prev % 2 == 0) {
                sum -= prev;
            }
            
            if(next % 2 == 0) {
                sum += next;
            }
            
            nums[x[1]] = next;
            
            ans[i] = sum;
            
            i++;
            
        }
        
        return ans;
    }
}