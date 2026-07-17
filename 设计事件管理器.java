class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer,Integer> map;
    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1])
            return Integer.compare(b[1],a[1]);
            else
            return Integer.compare(a[0],b[0]);
        }
        );
        map = new HashMap<>();
        for(int[] event:events){
            pq.offer(event);
            map.put(event[0],event[1]);
        }
    }
    public void updatePriority(int eventId, int newPriority) {
        pq.offer(new int[]{eventId,newPriority});
        map.put(eventId,newPriority);
    }
    public int pollHighest() {
        if(pq.isEmpty())
        return -1;
        int[] event = pq.poll();
        while((map.get(event[0])==null||event[1]!=map.get(event[0]))&&!pq.isEmpty()){
            event = pq.poll();
        }
        if(map.get(event[0])==null||event[1]!=map.get(event[0]))
        return -1;
        else{
        map.remove(event[0]);
        return event[0];
        }
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */