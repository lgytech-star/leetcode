class RangeFreqQuery {
    HashMap<Integer,List<Integer>> map;
    int []arr;
    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }
    }
    public int query(int left, int right, int value) {
         List list = map.get(value);
         if(list==null)
         return 0;
         int l = lowerbound(list,left);
         int r = lowerbound(list,right+1)-1;
         return r-l+1;
    }
    public int lowerbound(List<Integer> list,int target){
        int i = 0,j = list.size()-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(list.get(mid)<target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }
}

