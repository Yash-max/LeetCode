class Solution {
    int []parent;
    int find(int i)
    {
        if (parent[i] == i)
            return i;
        return find(parent[i]);
    }
    void union(int x, int y)
    {
        parent[x] = y;
    }
    public boolean equationsPossible(String[] equations) {
         
         parent = new int[26];
         for(int i = 0; i < 26; i++) {
             parent[i] = i;
         }
         
         for(String eq : equations) {
             int a = eq.charAt(0)-'a';
             int b = eq.charAt(3)-'a';
             if(eq.charAt(1) == '=') {
                int x = find(a);
                int y = find(b);
                 if(x != y) {
                     union(x, y);
                 }
             }
         }
        
        for(String eq : equations) {
             int a = eq.charAt(0)-'a';
             int b = eq.charAt(3)-'a';
             if(eq.charAt(1) == '!') {
                int x = find(a);  
                int y = find(b);  
                if(x == y) return false;
             }
         }
        
        return true;
    }
}