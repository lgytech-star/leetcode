class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int[] sum = new int[nums.length+1];
        int max = 0;
        int min = 0;
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
            max = Math.max(sum[i],max);
            min = Math.min(sum[i],min);
            ans = Math.max(Math.abs(max-min),ans);
        }
        return ans;
    }
}