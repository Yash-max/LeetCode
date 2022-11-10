class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(st.empty() || st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
        }
        List<Character> list = new ArrayList<>(st);
        return list.stream()
            .map(c -> Character.toString(c))
            .collect(
                Collectors.joining()
            );
    }
}