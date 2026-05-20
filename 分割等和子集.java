class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
        return false;
        int [][]dp = new int[nums.length][sum/2+1];
        for(int i=1;i<=sum/2;i++){
            if(i>=nums[0])
            dp[0][i] = nums[0]; 
        }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>=nums[i])
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[nums.length-1][sum/2]==sum/2)
        return true;
        else
        return false;
    }
}