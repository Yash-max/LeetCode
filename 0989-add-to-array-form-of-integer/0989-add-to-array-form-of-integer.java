class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        
        int carry = 0;
        int n = num.length;
        while(k > 0 || n > 0 || carry > 0) {
            int sum = (k > 0 ? k % 10: 0)
                + (n > 0 ? num[n-1]: 0)
                + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            k /= 10;
            n--;
        }
        Collections.reverse(ans);
        return ans;
    }
}