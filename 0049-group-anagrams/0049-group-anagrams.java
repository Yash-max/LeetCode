class Solution {
    public String hashedString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            String hash = hashedString(s);
            List<String> list = null;
            if(mp.containsKey(hash)) {
                list = mp.get(hash);
            } else {
                list = new ArrayList<>();
            }
            list.add(s);
            mp.put(hash, list);
        }
        
        for(String key: mp.keySet()) {
            List<String> list = mp.get(key);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}