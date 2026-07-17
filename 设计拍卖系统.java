class AuctionSystem {
    HashMap<Integer,PriorityQueue<int[]>> map1;
    HashMap<String,Integer> map;
    public AuctionSystem() {
        map1 = new HashMap<>();
        map = new HashMap<>();
    }
    public void addBid(int userId, int itemId, int bidAmount) {
        if(!map1.containsKey(itemId)){
            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
                if(a[1]!=b[1])
                return Integer.compare(b[1],a[1]);
                else
                return Integer.compare(b[0],a[0]);
            });
            map.put(String.valueOf(userId)+"."+String.valueOf(itemId),bidAmount);
            queue.offer(new int[]{userId,bidAmount});
            map1.put(itemId,queue);
        }else{
            PriorityQueue<int[]> queue = map1.get(itemId);
            queue.offer(new int[]{userId,bidAmount});
            map.put(String.valueOf(userId)+"."+String.valueOf(itemId),bidAmount);
        }
    }
    public void updateBid(int userId, int itemId, int newAmount) {
            PriorityQueue<int[]> queue = map1.get(itemId);
            queue.offer(new int[]{userId,newAmount});
            map.put(String.valueOf(userId)+"."+String.valueOf(itemId),newAmount);
    }
    public void removeBid(int userId, int itemId) {
        map.remove(String.valueOf(userId)+"."+String.valueOf(itemId));
    }
    public int getHighestBidder(int itemId) {
        if(!map1.containsKey(itemId))
        return -1;
        PriorityQueue<int[]> queue = map1.get(itemId);
        while(!queue.isEmpty()){
            int[] a = queue.peek();
            int userId = a[0];
            int bidAmount = a[1];
            if(map.containsKey(String.valueOf(userId)+"."+String.valueOf(itemId))){
                    if(bidAmount==map.get(String.valueOf(userId)+"."+String.valueOf(itemId)))
                    return userId;
            }
            queue.poll();
        }
        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */