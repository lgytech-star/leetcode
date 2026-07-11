class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> q = new PriorityQueue<>((a,b)->Double.compare(b,a));
        for(int i=0;i<nums.length;i++){
            sum+=(double)nums[i];
            q.offer((double)nums[i]);
        }
        double sum1 = sum;
        int ans = 0;
        while(sum1>sum/2){
            ans++;
            double x = q.poll();
            q.offer(x/2);
            sum1 = sum1-x/2;
        }
        return ans;
    }
}