class SeatManager {
    PriorityQueue<Integer> q;
    public SeatManager(int n) {
        q = new PriorityQueue<>();
        for(int i = 1;i<=n;i++){
            q.offer(i);
        }
    }
    public int reserve() {
        return q.poll();
    }
    
    public void unreserve(int seatNumber) {
        q.offer(seatNumber);
    }
}