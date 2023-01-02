class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 1) return true;
        char first = word.charAt(0);
        if(first >= 'a' && first <= 'z') {
            for(int i = 1; i < n; i++) {
                char itr = word.charAt(i);
                if(!(itr >= 'a' && itr <= 'z')) return false;
            }
        } else {
            char second = word.charAt(1);
            if(second >= 'A' && second <= 'Z') {
                for(int i = 2; i < n; i++) {
                    char itr = word.charAt(i);
                    if(!(itr >= 'A' && itr <= 'Z')) return false;
                }
            } else {
                for(int i = 2; i < n; i++) {
                    char itr = word.charAt(i);
                    if(!(itr >= 'a' && itr <= 'z')) return false;
                }
            }
        }
        return true;
    }
}