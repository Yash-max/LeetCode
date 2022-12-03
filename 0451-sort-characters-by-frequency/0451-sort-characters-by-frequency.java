class Dto {
    int freq;
    int ch;
    Dto(int freq, int ch) {
        this.freq = freq;
        this.ch = ch;
    }
}
class Solution {
    public String frequencySort(String s) {
        String ans = "";
        
        int []mp = new int[256];
        
        for(char ch : s.toCharArray()) {
            mp[ch]++;
        }
        
        PriorityQueue<Dto> pq = new PriorityQueue<>((a,b)->{
            if(a.freq != b.freq) return b.freq-a.freq;
            return b.ch-a.ch;
        });
        
        for(int i = 0; i < 256; i++) {
            if(mp[i] != 0) pq.add(new Dto(mp[i], i));
        }
        
        while(!pq.isEmpty()) {
            Dto dto = pq.poll();
            for(int i = 0; i < dto.freq; i++) {
                ans += (char)dto.ch;
            }
        }
        
        return ans;
    }
}