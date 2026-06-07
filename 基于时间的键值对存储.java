class TimeMap {
    Map<String,List<Info>> map;
    static class Info{
        int timestamp;
        String value;
        public Info(int timestamp,String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            List<Info> list = new ArrayList<>();
            list.add(new Info(timestamp,value));
            map.put(key,list);
        }else{
            List list = map.get(key);
            list.add(new Info(timestamp,value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        return "";
        int a = lowerbound(timestamp+1,key)-1;
        List<Info> list = map.get(key);
        if(a<0)
        return "";
        else
        return list.get(a).value;
    }
    public int lowerbound(int timestamp,String key){
        List<Info> list = map.get(key);
        int left = 0,right = list.size()-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(timestamp > list.get(mid).timestamp){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}