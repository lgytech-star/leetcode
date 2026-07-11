class RideSharingSystem {
    Deque<Integer> rider;
    Deque<Integer> driver;
    public RideSharingSystem() {
        rider = new ArrayDeque<>();
        driver = new ArrayDeque<>();
    }
    public void addRider(int riderId) {
        rider.offer(riderId);   
    }
    
    public void addDriver(int driverId) {
        driver.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if(!driver.isEmpty()&&!rider.isEmpty()){
            return new int[]{driver.poll(),rider.poll()};
        }
        return new int[]{-1,-1};
    }
    public void cancelRider(int riderId) {
           rider.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */