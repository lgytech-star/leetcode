class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
        }
        int [][]dp = new int[stones.length][sum/2+1];
        for(int i=1;i<=sum/2;i++){
            if(i>=stones[0])
            dp[0][i] = stones[0];
        }
        for(int i=1;i<stones.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>=stones[i])
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return Math.abs(sum-dp[stones.length-1][sum/2]-dp[stones.length-1][sum/2]);
    }
}