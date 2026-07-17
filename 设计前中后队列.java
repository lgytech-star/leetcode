class FrontMiddleBackQueue {
    ListNode head;
    ListNode tail;
    ListNode mid;
    int size;
    int midindex;
    public FrontMiddleBackQueue() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
        midindex = 0;
        mid = head;
    }
    public void pushFront(int val) {
        int oldSize = size;                     // 保存插入前的大小
        ListNode node = new ListNode(val);
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
        if (oldSize == 0) {
            mid = node;                        
        } else if (oldSize % 2 == 1) {
            mid = mid.pre;                    
        }
        size++;
}
    public void pushMiddle(int val) {
        ListNode node = new ListNode(val);
        if(size%2!=0){
        node.pre = mid.pre;
        node.next = mid;
        mid.pre = node;
        node.pre.next = node;
        mid = mid.pre;
        }
        else{
        node.next = mid.next;
        mid.next = node;
        node.pre = mid;
        node.next.pre = node;
        mid = mid.next;
        }
        size++;
    }
    public void pushBack(int val) {
        size++;
        ListNode node = new ListNode(val);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        if(size%2!=0)
        mid = mid.next;
    }
    public int popFront() {
        if(size==0) return -1;
        ListNode node = head.next;
        head.next = node.next;
        node.next.pre = head;
        size--;
        if(size==0) {
            mid = head;
        } else if(size%2!=0) {
            mid = mid.next;  // 此时 mid 指向 node，node.next 还未被置 null，所以 mid.next 正确
        }
        node.next = null;
        node.pre = null;
        return node.val;
    }
    public int popMiddle() {
        if(size==0)
        return -1;
        ListNode node = mid;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        if(size%2==0)
        mid = node.next;
        else
        mid = node.pre;
        node.pre = null;
        node.next = null;
        size--;
        return node.val;
    }
    
    public int popBack() {
        if(size==0) return -1;
        ListNode node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;
        size--;
        if(size%2==0)
            mid = mid.pre;   // 此时 mid 指向 node，node.pre 还未被置 null，所以 mid.pre 正确
        node.next = null;
        node.pre = null;
        return node.val;
    }
}
class ListNode{
        int val;
        ListNode next;
        ListNode pre;
        public ListNode(int val,ListNode next,ListNode pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
        public ListNode(int val){
            this.val = val;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */