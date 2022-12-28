class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int x : piles) {
            pq.add(x);
        }
        while(k > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            // System.out.print(top + " ");
            if(top > 0) pq.add((int)(top-Math.floor(top/2)));
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}