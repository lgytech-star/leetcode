class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum+target)%2!=0||Math.abs(target)>sum)
        return 0;
        int weight = (sum+target)/2;
        int [][]dp = new int[nums.length][weight+1];
        for(int i=1;i<=weight;i++){
            if(nums[0]==i){
                dp[0][i] = 1;
            }
        }
        int numsZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            numsZero++;
            dp[i][0] = (int) Math.pow(2, numsZero);
        }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=weight;j++){
                if(j>=nums[i])
                dp[i][j] = dp[i-1][j-nums[i]]+dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length-1][weight];
    }
}