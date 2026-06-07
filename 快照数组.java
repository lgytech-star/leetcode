class SnapshotArray {
    int curSnapId;
    HashMap<Integer,List<int[]>> map;
    public SnapshotArray(int length) {
        map = new HashMap<>();
        }
    public void set(int index, int val) {
        if(map.get(index)==null){
            List<int[]> a = new ArrayList<>();
            map.put(index,a);
            a.add(new int[]{curSnapId,val});
        }else{
            List a = map.get(index);
            a.add(new int[]{curSnapId,val});
        }
    }
    public int snap() {
       return curSnapId++;
    }
    public int get(int index, int snap_id) {
        if(!map.containsKey(index))
        return 0;
        List<int[]> a = map.get(index);
        int num = search(a,snap_id+1)-1;
        if(num<0)
        return 0;
        return a.get(num)[1];
    }
    public int search(List<int[]> a,int snap_id){
        int left = 0, right = a.size()-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(a.get(mid)[0]<snap_id){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}

