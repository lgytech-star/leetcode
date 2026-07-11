class MyCircularQueue {
    int maxsize,size;
    ListNode head,tail;
    public MyCircularQueue(int k) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        this.head.next = tail;
        this.tail.pre = head;
        this.maxsize = k;
        this.size = 0;
    }
    public boolean enQueue(int value) {
        if(this.isFull())
        return false;
        size++;
        ListNode node = new ListNode(value);
        ListNode p = tail.pre;
        p.next = node;
        node.pre = p;
        node.next = tail;
        tail.pre = node;
        return true;
    }
    public boolean deQueue() {
        if(this.isEmpty())
        return false;
        ListNode node = head.next;
        head.next = node.next;
        node.next.pre = head;
        node.next = null;
        node.pre = null;
        size--;
        return true;
    }
    public int Front() {
        return head.next.val;
    }
    public int Rear() {
        return tail.pre.val;
    }
    public boolean isEmpty() {
        if(head.next==tail)
        return true;
        return false;
    }
    public boolean isFull() {
        if(this.size==this.maxsize)
        return true;
        return false;
    }
}
class ListNode{
    int val;
    ListNode next,pre;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next,ListNode pre){
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */