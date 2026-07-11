class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long ans = 1;
        for(int i=0;i<nums.length;i++){
            q.offer(nums[i]);
        }
        for(int i = 0;i<k;i++){
            int x = q.poll();
            q.offer(x+1);
        }
        while(!q.isEmpty()){
            int x = q.poll();
            ans=(ans*x)%1000000007;
        }
        return (int)(ans % 1000000007);
    }
}