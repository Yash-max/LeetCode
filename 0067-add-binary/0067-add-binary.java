class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        int carry = 0;
        while(n > 0 || m > 0 || carry > 0) {
            int current = carry + (n > 0 ? (a.charAt(n-1)-'0'): 0) + (m > 0 ? (b.charAt(m-1)-'0'): 0);
            carry = current / 2;
            sb.append(Integer.toString(current % 2));
            n--; m--;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}