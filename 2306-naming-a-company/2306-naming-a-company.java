class Solution {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        long ans = 0;
        
        Set<String> []set = new HashSet[26];
        for(int i = 0; i < 26; i++) {
            set[i] = new HashSet<String>();
        }
        
        for(String s : ideas) {
            set[s.charAt(0)-'a'].add(s.substring(1));
        }
        
        for(int i = 0; i < 25; ++i) {
            for(int j = i + 1; j < 26; ++j) {
                long numOfMutual = 0;
                for (String ideaA : set[i]) {
                    if (set[j].contains(ideaA)) {
                        numOfMutual++;
                    }
                }
                ans += 2 * (set[i].size() - numOfMutual) * (set[j].size() - numOfMutual);
            }
        }
        
        return ans;
    }
}