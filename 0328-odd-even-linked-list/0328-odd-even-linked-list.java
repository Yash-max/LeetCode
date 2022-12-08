class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        boolean isOdd = true;
        while(odd.next != null && even.next != null) {
            if(isOdd) {
                odd.next = even.next;
                odd = odd.next;
            } else {
                even.next = odd.next;
                even = even.next;
            }
            isOdd = !isOdd;
        }

        odd.next  = evenStart;
        even.next = null;

        return head;
    }
}