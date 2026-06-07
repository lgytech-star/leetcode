class Router {
    Map<Integer,List<Info>> map;
    List<Info> list;
    Set<Info> set;
    int memoryLimit;
    private record Info(int source, int destination, int timestamp) {
    }
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        list = new ArrayList<>();
        set = new HashSet<>();
        map = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Info info = new Info(source,destination,timestamp);
        if(set.contains(info))
            return false;
        if(list.size()==memoryLimit){
            map.get(list.get(0).destination).remove(0);
            set.remove(list.get(0));
            list.remove(0);
        }
        list.add(info);
        set.add(info);
        if(map.containsKey(destination)){
        List<Info> info1 = map.get(info.destination);
        info1.add(info);
        }else{
            List<Info> info1 = new ArrayList<>();
            info1.add(info);
            map.put(destination,info1);
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if(list.size()==0)
        return new int[]{};
        Info info = list.get(0);
        set.remove(info);
        list.remove(0);
        map.get(info.destination).remove(0);
        return new int[]{info.source,info.destination,info.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!map.containsKey(destination))
        return 0;
        List<Info> info = map.get(destination);
        int left = lowerbound(destination,startTime);
        int right = lowerbound(destination,endTime+1)-1;
        if(left>info.size()||right<0)
        return 0;
        else
        return right-left+1;
    }
    public int lowerbound(int destination,int time){
    //   if(!map.containsKey(destination))
    //     return 0;
       List<Info> info =  map.get(destination);
       int left = 0, right = info.size()-1;
       while(left<=right){
        int mid = left + (right - left) / 2;
        if(time>info.get(mid).timestamp)
            left = mid + 1;
        else
            right = mid - 1;
       }
       return left;
    }
}