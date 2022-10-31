class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries[0].length();
        List<String> ans = new ArrayList<>();
        for(String q : queries) {
            boolean flag = false;
            for(String d : dictionary) {
                int diff = 0;
                for(int i = 0; i < n && diff < 3; i++) {
                    if(q.charAt(i) != d.charAt(i)) {
                        diff++;
                    }
                }
                if(diff <= 2) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                ans.add(q);
            }
        }
        return ans;
    }
}