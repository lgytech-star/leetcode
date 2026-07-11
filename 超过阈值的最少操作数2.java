class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            q.offer((long)nums[i]);
        }
        while(q.peek()<k&&q.size()>=2){
            ans++;
            long x = q.poll();
            long y = q.poll();
            q.offer(Math.min(x,y)*2+Math.max(x,y));
        }
        return ans;
    }
}