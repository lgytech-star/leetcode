class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
       int premax_1 = nums[0]-0;
       int ans = 0;
       for(int i=1;i<nums.length;i++){
                ans = Math.max(nums[i]-i+premax_1,ans);
                premax_1 = Math.max(nums[i]+i,premax_1);
       }
       return ans; 
    }
}