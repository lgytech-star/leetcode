class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int []m,int []n){
                return m[1]-n[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(q.size()==k){
                if(q.peek()[1]<count){
                    q.poll();
                    q.offer(new int[]{num,count});
                }
            }else{
                q.offer(new int[]{num,count});
            }
        }
        int []res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = q.poll()[0];
        }
        return res;
    }
}