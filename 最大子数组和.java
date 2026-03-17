class Solution {
    public int maxSubArray(int[] nums) {
        int []a = new int[nums.length];
        a[0]=nums[0];
        int max=a[0];
        for(int i=1;i<nums.length;i++){
            a[i]=Math.max(nums[i],a[i-1]+nums[i]);
            max=Math.max(max,a[i]);
        }
        return max;
    }
}