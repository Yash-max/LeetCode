class Solution {
public:
    bool util(string s1, string s2, vector<int> &mp) {
        for(int i = 0; i < min(s1.length(), s2.length()); i++) {
            if(mp[s1[i]-'a'] < mp[s2[i]-'a']) {
               return true; 
            } else if(mp[s1[i]-'a'] > mp[s2[i]-'a']) {
                return false;
            }
        }
        if(s1.length() > s2.length()) {
            return false;
        } return true;
    }
    bool isAlienSorted(vector<string>& words, string order) {
        vector<int> mp(26);
        for(int i = 0; i < 26; i++) {
            mp[order[i]-'a'] = i;
        }
        for(int i = 0; i < words.size()-1; i++) {
            if(util(words[i], words[i+1], mp) == false) {
                return false;
            }
        }
        return true;
    }
};