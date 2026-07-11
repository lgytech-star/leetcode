class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int []sum = new int[nums.length+1];
        int []result = new int[nums.length];
        for(int i=1;i<=nums.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        for(int i=0;i<nums.length;i++){
            result[i] = Math.abs(sum[i+1]-(i+1)*nums[i]) + (sum[nums.length]-sum[i+1])-((nums.length-i-1)*nums[i]);
        }
        return result;
    }
}