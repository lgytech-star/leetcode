class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode head1 = new ListNode(-1,head);
        ListNode a = head1;
        while(a.next!=null&&a.next.next!=null){
            ListNode b= a.next;
            ListNode c = b.next;
            b.next = c.next;
            c.next = b;
            a.next = c;
            a = b;
        }
        return head1.next;
    }
}