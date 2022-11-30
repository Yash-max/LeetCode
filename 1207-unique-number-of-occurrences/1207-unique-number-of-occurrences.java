class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        int []map = new int[2001];
        
        for(int x : arr) {
            map[x+1000]++;
        }
        
        Set<Integer> set = new TreeSet<>();
        
        for(int i = 0; i <= 2000; i++) {
            if(map[i] != 0) {
                if(set.contains(map[i])) {
                    return false;
                }
                set.add(map[i]);
            }
        }
        
        return true;
    }
}