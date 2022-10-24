class Solution {
    private boolean isConcatable(int[] dp, int[] temp) {
        for(int i = 0; i < 26; i++) {
            if(dp[i] + temp[i] > 1) return false;
        }
        return true;
    }
    private void concat(int[] dp, int[] temp) {
        for(int i = 0; i < 26; i++) {
            dp[i] += temp[i];
        }
    }
    private void removeConcat(int[] dp, int[] temp) {
        for(int i = 0; i < 26; i++) {
            dp[i] -= temp[i];
        }
    }
    private int util(List<String> arr, int n, List<int[]> list, int []dp) {
        if(n == 0) return 0;
        int ans = 0;
        if(isConcatable(dp, list.get(n-1))) {
            concat(dp, list.get(n-1));
            ans = arr.get(n-1).length() + util(arr, n-1, list, dp);
            removeConcat(dp, list.get(n-1));
        }
        ans = Math.max(ans, util(arr, n-1, list, dp));
        return ans;
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<int[]> list = new ArrayList<>();
        for(String s : arr) {
            int []freq = new int[26];
            for(char ch: s.toCharArray()) {
                freq[ch-'a']++;
            }
            list.add(freq);
        }
        int []dp = new int[26];
        return util(arr, n, list, dp);
    }
}