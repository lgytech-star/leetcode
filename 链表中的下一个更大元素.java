/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode h = head;
        int length = 0;
        List<Integer> list = new ArrayList<>();
        while(h!=null){
            list.add(h.val);
            length++;
            h = h.next;
        }
        int []ans = new int[length];
        h = head;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<length;i++){
            while(!q.isEmpty()&&h.val>list.get(q.peek())){
                ans[q.peek()] = h.val;
                q.pop();
            }
            q.push(i);
            h = h.next;
        }
        return ans;
    }
}