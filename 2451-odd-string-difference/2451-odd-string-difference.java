class Solution {
    private List<Integer> diffArray(String word) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < word.length(); i++) {
            list.add(word.charAt(i)-word.charAt(i-1));
        }
        return list;
    }
    public String oddString(String[] words) {
        int ans = -1;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            List<Integer> list = diffArray(words[i]);
            // System.out.println(list);
            if(map.keySet().size() == 2) {
                for(List<Integer> l : map.keySet()) {
                    if(l.equals(list) == false) {
                        // System.out.println("list");
                        ans = map.get(l);
                        break;
                    }
                }
            }
            map.put(list, i);
        }
        if(ans == -1) ans = words.length-1;
        return words[ans];
    }
}